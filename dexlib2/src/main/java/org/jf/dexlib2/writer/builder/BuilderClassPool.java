/*
 * Copyright 2013, Google Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.jf.dexlib2.writer.builder;




import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

import org.jf.dexlib2.DebugItemType;
import org.jf.dexlib2.builder.MutableMethodImplementation;
import org.jf.dexlib2.iface.ExceptionHandler;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.TryBlock;
import org.jf.dexlib2.iface.debug.DebugItem;
import org.jf.dexlib2.iface.debug.EndLocal;
import org.jf.dexlib2.iface.debug.LineNumber;
import org.jf.dexlib2.iface.debug.RestartLocal;
import org.jf.dexlib2.iface.debug.SetSourceFile;
import org.jf.dexlib2.iface.debug.StartLocal;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.iface.reference.TypeReference;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.util.EncodedValueUtils;
import org.jf.dexlib2.writer.ClassSection;
import org.jf.dexlib2.writer.DebugWriter;
import org.jf.dexlib2.writer.builder.BuilderEncodedValues.BuilderEncodedValue;
import org.jf.util.AbstractForwardSequentialList;
import org.jf.util.CollectionUtils;
import org.jf.util.ExceptionWithContext;

import java.io.IOException;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;

public class BuilderClassPool extends BaseBuilderPool implements ClassSection<BuilderStringReference,
        BuilderTypeReference, BuilderTypeList, BuilderClassDef, BuilderField, BuilderMethod, BuilderAnnotationSet,
        BuilderEncodedValue> {

    private final ConcurrentMap<String, BuilderClassDef> internedItems =
            Maps.newConcurrentMap();

    public BuilderClassPool(DexBuilder dexBuilder) {
        super(dexBuilder);
    }


    BuilderClassDef internClass(BuilderClassDef classDef) {
        BuilderClassDef prev = internedItems.put(classDef.getType(), classDef);
        if (prev != null) {
            throw new ExceptionWithContext("Class %s has already been interned", classDef.getType());
        }
        return classDef;
    }

    private ImmutableList<BuilderClassDef> sortedClasses = null;


    @Override
    public Collection<? extends BuilderClassDef> getSortedClasses() {
        if (sortedClasses == null) {
            sortedClasses = Ordering.natural().immutableSortedCopy(internedItems.values());
        }
        return sortedClasses;
    }


    @Override
    public Entry<? extends BuilderClassDef, Integer> getClassEntryByType(BuilderTypeReference type) {
        if (type == null) {
            return null;
        }

        final BuilderClassDef classDef = internedItems.get(type.getType());
        if (classDef == null) {
            return null;
        }

        return new Map.Entry<BuilderClassDef, Integer>() {
            @Override
            public BuilderClassDef getKey() {
                return classDef;
            }

            @Override
            public Integer getValue() {
                return classDef.classDefIndex;
            }

            @Override
            public Integer setValue(Integer value) {
                return classDef.classDefIndex = value;
            }
        };
    }


    @Override
    public BuilderTypeReference getType(BuilderClassDef builderClassDef) {
        return builderClassDef.type;
    }

    @Override
    public int getAccessFlags(BuilderClassDef builderClassDef) {
        return builderClassDef.accessFlags;
    }


    @Override
    public BuilderTypeReference getSuperclass(BuilderClassDef builderClassDef) {
        return builderClassDef.superclass;
    }


    @Override
    public BuilderTypeList getInterfaces(BuilderClassDef builderClassDef) {
        return builderClassDef.interfaces;
    }


    @Override
    public BuilderStringReference getSourceFile(BuilderClassDef builderClassDef) {
        return builderClassDef.sourceFile;
    }

    private static final Predicate<Field> HAS_INITIALIZER = new Predicate<Field>() {
        @Override
        public boolean apply(Field input) {
            EncodedValue encodedValue = input.getInitialValue();
            return encodedValue != null && !EncodedValueUtils.isDefaultValue(encodedValue);
        }
    };

    private static final Function<BuilderField, BuilderEncodedValue> GET_INITIAL_VALUE =
            new Function<BuilderField, BuilderEncodedValue>() {
                @Override
                public BuilderEncodedValue apply(BuilderField input) {
                    BuilderEncodedValue initialValue = input.getInitialValue();
                    if (initialValue == null) {
                        return BuilderEncodedValues.defaultValueForType(input.getType());
                    }
                    return initialValue;
                }
            };


    @Override
    public Collection<? extends BuilderEncodedValue> getStaticInitializers(BuilderClassDef classDef) {
        final SortedSet<BuilderField> sortedStaticFields = classDef.getStaticFields();

        final int lastIndex = CollectionUtils.lastIndexOf(sortedStaticFields, HAS_INITIALIZER);
        if (lastIndex > -1) {
            return new AbstractCollection<BuilderEncodedValue>() {

                @Override
                public Iterator<BuilderEncodedValue> iterator() {
                    return FluentIterable.from(sortedStaticFields)
                            .limit(lastIndex + 1)
                            .transform(GET_INITIAL_VALUE).iterator();
                }

                @Override
                public int size() {
                    return lastIndex + 1;
                }
            };
        }
        return null;
    }


    @Override
    public Collection<? extends BuilderField> getSortedStaticFields(BuilderClassDef builderClassDef) {
        return builderClassDef.getStaticFields();
    }


    @Override
    public Collection<? extends BuilderField> getSortedInstanceFields(BuilderClassDef builderClassDef) {
        return builderClassDef.getInstanceFields();
    }


    @Override
    public Collection<? extends BuilderField> getSortedFields(BuilderClassDef builderClassDef) {
        return builderClassDef.getFields();
    }


    @Override
    public Collection<? extends BuilderMethod> getSortedDirectMethods(BuilderClassDef builderClassDef) {
        return builderClassDef.getDirectMethods();
    }


    @Override
    public Collection<? extends BuilderMethod> getSortedVirtualMethods(BuilderClassDef builderClassDef) {
        return builderClassDef.getVirtualMethods();
    }


    @Override
    public Collection<? extends BuilderMethod> getSortedMethods(BuilderClassDef builderClassDef) {
        return builderClassDef.getMethods();
    }

    @Override
    public int getFieldAccessFlags(BuilderField builderField) {
        return builderField.accessFlags;
    }

    @Override
    public int getMethodAccessFlags(BuilderMethod builderMethod) {
        return builderMethod.accessFlags;
    }


    @Override
    public BuilderAnnotationSet getClassAnnotations(BuilderClassDef builderClassDef) {
        if (builderClassDef.annotations.isEmpty()) {
            return null;
        }
        return builderClassDef.annotations;
    }


    @Override
    public BuilderAnnotationSet getFieldAnnotations(BuilderField builderField) {
        if (builderField.annotations.isEmpty()) {
            return null;
        }
        return builderField.annotations;
    }


    @Override
    public BuilderAnnotationSet getMethodAnnotations(BuilderMethod builderMethod) {
        if (builderMethod.annotations.isEmpty()) {
            return null;
        }
        return builderMethod.annotations;
    }

    private static final Predicate<BuilderMethodParameter> HAS_PARAMETER_ANNOTATIONS =
            new Predicate<BuilderMethodParameter>() {
                @Override
                public boolean apply(BuilderMethodParameter input) {
                    return input.getAnnotations().size() > 0;
                }
            };

    private static final Function<BuilderMethodParameter, BuilderAnnotationSet> PARAMETER_ANNOTATIONS =
            new Function<BuilderMethodParameter, BuilderAnnotationSet>() {
                @Override
                public BuilderAnnotationSet apply(BuilderMethodParameter input) {
                    return input.getAnnotations();
                }
            };


    @Override
    public List<? extends BuilderAnnotationSet> getParameterAnnotations(
            final BuilderMethod method) {
        final List<? extends BuilderMethodParameter> parameters = method.getParameters();
        boolean hasParameterAnnotations = Iterables.any(parameters, HAS_PARAMETER_ANNOTATIONS);

        if (hasParameterAnnotations) {
            return new AbstractForwardSequentialList<BuilderAnnotationSet>() {

                @Override
                public Iterator<BuilderAnnotationSet> iterator() {
                    return FluentIterable.from(parameters)
                            .transform(PARAMETER_ANNOTATIONS).iterator();
                }

                @Override
                public int size() {
                    return parameters.size();
                }
            };
        }
        return null;
    }


    @Override
    public Iterable<? extends DebugItem> getDebugItems(BuilderMethod builderMethod) {
        MethodImplementation impl = builderMethod.getImplementation();
        if (impl == null) {
            return null;
        }
        return impl.getDebugItems();
    }


    @Override
    public Iterable<? extends BuilderStringReference> getParameterNames(BuilderMethod method) {
        return Iterables.transform(method.getParameters(), new Function<BuilderMethodParameter, BuilderStringReference>() {

            @Override
            public BuilderStringReference apply(BuilderMethodParameter input) {
                return input.name;
            }
        });
    }

    @Override
    public int getRegisterCount(BuilderMethod builderMethod) {
        MethodImplementation impl = builderMethod.getImplementation();
        if (impl == null) {
            return 0;
        }
        return impl.getRegisterCount();
    }


    @Override
    public Iterable<? extends Instruction> getInstructions(BuilderMethod builderMethod) {
        MethodImplementation impl = builderMethod.getImplementation();
        if (impl == null) {
            return null;
        }
        return impl.getInstructions();
    }


    @Override
    public List<? extends TryBlock<? extends ExceptionHandler>> getTryBlocks(BuilderMethod builderMethod) {
        MethodImplementation impl = builderMethod.getImplementation();
        if (impl == null) {
            return ImmutableList.of();
        }
        return impl.getTryBlocks();
    }


    @Override
    public BuilderTypeReference getExceptionType(ExceptionHandler handler) {
        return checkTypeReference(handler.getExceptionTypeReference());
    }


    @Override
    public MutableMethodImplementation makeMutableMethodImplementation(BuilderMethod builderMethod) {
        MethodImplementation impl = builderMethod.getImplementation();
        if (impl instanceof MutableMethodImplementation) {
            return (MutableMethodImplementation) impl;
        }
        return new MutableMethodImplementation(impl);
    }

    @Override
    public void setEncodedArrayOffset(BuilderClassDef builderClassDef, int offset) {
        builderClassDef.encodedArrayOffset = offset;
    }

    @Override
    public int getEncodedArrayOffset(BuilderClassDef builderClassDef) {
        return builderClassDef.encodedArrayOffset;
    }

    @Override
    public void setAnnotationDirectoryOffset(BuilderClassDef builderClassDef, int offset) {
        builderClassDef.annotationDirectoryOffset = offset;
    }

    @Override
    public int getAnnotationDirectoryOffset(BuilderClassDef builderClassDef) {
        return builderClassDef.annotationDirectoryOffset;
    }

    @Override
    public void setAnnotationSetRefListOffset(BuilderMethod builderMethod, int offset) {
        builderMethod.annotationSetRefListOffset = offset;
    }

    @Override
    public int getAnnotationSetRefListOffset(BuilderMethod builderMethod) {
        return builderMethod.annotationSetRefListOffset;
    }

    @Override
    public void setCodeItemOffset(BuilderMethod builderMethod, int offset) {
        builderMethod.codeItemOffset = offset;
    }

    @Override
    public int getCodeItemOffset(BuilderMethod builderMethod) {
        return builderMethod.codeItemOffset;
    }


    private BuilderStringReference checkStringReference(StringReference stringReference) {
        if (stringReference == null) {
            return null;
        }
        try {
            return (BuilderStringReference) stringReference;
        } catch (ClassCastException ex) {
            throw new IllegalStateException("Only StringReference instances returned by " +
                    "DexBuilder.internStringReference or DexBuilder.internNullableStringReference may be used.");
        }
    }


    private BuilderTypeReference checkTypeReference(TypeReference typeReference) {
        if (typeReference == null) {
            return null;
        }
        try {
            return (BuilderTypeReference) typeReference;
        } catch (ClassCastException ex) {
            throw new IllegalStateException("Only TypeReference instances returned by " +
                    "DexBuilder.internTypeReference or DexBuilder.internNullableTypeReference may be used.");
        }
    }

    @Override
    public void writeDebugItem(DebugWriter<BuilderStringReference, BuilderTypeReference> writer,
                               DebugItem debugItem) throws IOException {
        switch (debugItem.getDebugItemType()) {
            case DebugItemType.START_LOCAL: {
                StartLocal startLocal = (StartLocal) debugItem;
                writer.writeStartLocal(startLocal.getCodeAddress(),
                        startLocal.getRegister(),
                        checkStringReference(startLocal.getNameReference()),
                        checkTypeReference(startLocal.getTypeReference()),
                        checkStringReference(startLocal.getSignatureReference()));
                break;
            }
            case DebugItemType.END_LOCAL: {
                EndLocal endLocal = (EndLocal) debugItem;
                writer.writeEndLocal(endLocal.getCodeAddress(), endLocal.getRegister());
                break;
            }
            case DebugItemType.RESTART_LOCAL: {
                RestartLocal restartLocal = (RestartLocal) debugItem;
                writer.writeRestartLocal(restartLocal.getCodeAddress(), restartLocal.getRegister());
                break;
            }
            case DebugItemType.PROLOGUE_END: {
                writer.writePrologueEnd(debugItem.getCodeAddress());
                break;
            }
            case DebugItemType.EPILOGUE_BEGIN: {
                writer.writeEpilogueBegin(debugItem.getCodeAddress());
                break;
            }
            case DebugItemType.LINE_NUMBER: {
                LineNumber lineNumber = (LineNumber) debugItem;
                writer.writeLineNumber(lineNumber.getCodeAddress(), lineNumber.getLineNumber());
                break;
            }
            case DebugItemType.SET_SOURCE_FILE: {
                SetSourceFile setSourceFile = (SetSourceFile) debugItem;
                writer.writeSetSourceFile(setSourceFile.getCodeAddress(),
                        checkStringReference(setSourceFile.getSourceFileReference()));
                break;
            }
            default:
                throw new ExceptionWithContext("Unexpected debug item type: %d", debugItem.getDebugItemType());
        }
    }

    @Override
    public int getItemIndex(BuilderClassDef builderClassDef) {
        return builderClassDef.classDefIndex;
    }


    @Override
    public Collection<? extends Entry<? extends BuilderClassDef, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderClassDef>(internedItems.values()) {
            @Override
            protected int getValue(BuilderClassDef key) {
                return key.classDefIndex;
            }

            @Override
            protected int setValue(BuilderClassDef key, int value) {
                int prev = key.classDefIndex;
                key.classDefIndex = value;
                return prev;
            }
        };
    }

    @Override
    public int getItemCount() {
        return internedItems.size();
    }
}
