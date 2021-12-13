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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.ValueType;
import org.jf.dexlib2.base.BaseExceptionHandler;
import org.jf.dexlib2.base.BaseTryBlock;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.ExceptionHandler;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.MethodParameter;
import org.jf.dexlib2.iface.TryBlock;
import org.jf.dexlib2.iface.UpdateReference;
import org.jf.dexlib2.iface.debug.DebugItem;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.iface.reference.*;
import org.jf.dexlib2.iface.value.*;
import org.jf.dexlib2.writer.DexWriter;
import org.jf.dexlib2.writer.builder.BuilderEncodedValues.*;
import org.jf.util.ExceptionWithContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class DexBuilder extends DexWriter<BuilderStringReference, BuilderStringReference, BuilderTypeReference,
        BuilderTypeReference, BuilderMethodProtoReference, BuilderFieldReference, BuilderMethodReference,
        BuilderClassDef, BuilderAnnotation, BuilderAnnotationSet, BuilderTypeList, BuilderField, BuilderMethod,
        BuilderEncodedValue, BuilderAnnotationElement, BuilderStringPool, BuilderTypePool, BuilderProtoPool,
        BuilderFieldPool, BuilderMethodPool, BuilderClassPool, BuilderTypeListPool, BuilderAnnotationPool,
        BuilderAnnotationSetPool> {

    public DexBuilder(Opcodes opcodes) {
        super(opcodes);
    }

    
    @Override
    protected SectionProvider getSectionProvider() {
        return new DexBuilderSectionProvider();
    }

    
    public BuilderField internField(String definingClass,
                                    String name,
                                    String type,
                                    int accessFlags,
                                    EncodedValue initialValue,
                                    Set<? extends Annotation> annotations) {
        return new BuilderField(fieldSection.internField(definingClass, name, type),
                accessFlags,
                internNullableEncodedValue(initialValue),
                annotationSetSection.internAnnotationSet(annotations));
    }

    
    public BuilderMethod internMethod(String definingClass,
                                      String name,
                                      List<? extends MethodParameter> parameters,
                                      String returnType,
                                      int accessFlags,
                                      Set<? extends Annotation> annotations,
                                      MethodImplementation methodImplementation) {
        if (parameters == null) {
            parameters = ImmutableList.of();
        }
        return new BuilderMethod(methodSection.internMethod(definingClass, name, parameters, returnType),
                internMethodParameters(parameters),
                accessFlags,
                annotationSetSection.internAnnotationSet(annotations),
                methodImplementation);
    }

    
    public BuilderClassDef internClassDef(String type,
                                          int accessFlags,
                                          String superclass,
                                          List<String> interfaces,
                                          String sourceFile,
                                          Set<? extends Annotation> annotations,
                                          Iterable<? extends BuilderField> fields,
                                          Iterable<? extends BuilderMethod> methods) {
        if (interfaces == null) {
            interfaces = ImmutableList.of();
        } else {
            Set<String> interfaces_copy = Sets.newHashSet(interfaces);
            Iterator<String> interfaceIterator = interfaces.iterator();
            while (interfaceIterator.hasNext()) {
                String iface = interfaceIterator.next();
                if (!interfaces_copy.contains(iface)) {
                    interfaceIterator.remove();
                } else {
                    interfaces_copy.remove(iface);
                }
            }
        }

        return classSection.internClass(new BuilderClassDef(typeSection.internType(type),
                accessFlags,
                typeSection.internNullableType(superclass),
                typeListSection.internTypeList(interfaces),
                stringSection.internNullableString(sourceFile),
                annotationSetSection.internAnnotationSet(annotations),
                fields,
                methods));
    }

    
    public BuilderStringReference internStringReference(String string) {
        return stringSection.internString(string);
    }


    public BuilderStringReference internNullableStringReference(String string) {
        if (string != null) {
            return internStringReference(string);
        }
        return null;
    }

    
    public BuilderTypeReference internTypeReference(String type) {
        return typeSection.internType(type);
    }


    public BuilderTypeReference internNullableTypeReference(String type) {
        if (type != null) {
            return internTypeReference(type);
        }
        return null;
    }

    
    public BuilderFieldReference internFieldReference(FieldReference field) {
        return fieldSection.internField(field);
    }

    
    public BuilderMethodReference internMethodReference(MethodReference method) {
        return methodSection.internMethod(method);
    }

    
    public BuilderMethodProtoReference internMethodProtoReference(MethodProtoReference methodProto) {
        return protoSection.internMethodProto(methodProto);
    }

    
    public BuilderReference internReference(Reference reference) {
        if (reference instanceof StringReference) {
            return internStringReference(((StringReference) reference).getString());
        }
        if (reference instanceof TypeReference) {
            return internTypeReference(((TypeReference) reference).getType());
        }
        if (reference instanceof MethodReference) {
            return internMethodReference((MethodReference) reference);
        }
        if (reference instanceof FieldReference) {
            return internFieldReference((FieldReference) reference);
        }
        if (reference instanceof MethodProtoReference) {
            return internMethodProtoReference((MethodProtoReference) reference);
        }
        throw new IllegalArgumentException("Could not determine type of reference");
    }

    
    private List<BuilderMethodParameter> internMethodParameters(
            List<? extends MethodParameter> methodParameters) {
        if (methodParameters == null) {
            return ImmutableList.of();
        }
        return ImmutableList.copyOf(Iterators.transform(methodParameters.iterator(),
                new Function<MethodParameter, BuilderMethodParameter>() {

                    @Override
                    public BuilderMethodParameter apply(MethodParameter input) {
                        return internMethodParameter(input);
                    }
                }));
    }
    
    
    private BuilderMethodParameter internMethodParameter(MethodParameter methodParameter) {
        return new BuilderMethodParameter(
                typeSection.internType(methodParameter.getType()),
                stringSection.internNullableString(methodParameter.getName()),
                annotationSetSection.internAnnotationSet(methodParameter.getAnnotations()));
    }

    @Override
    protected void writeEncodedValue(InternalEncodedValueWriter writer,
                                     BuilderEncodedValue encodedValue) throws IOException {
        switch (encodedValue.getValueType()) {
            case ValueType.ANNOTATION:
                BuilderAnnotationEncodedValue annotationEncodedValue = (BuilderAnnotationEncodedValue) encodedValue;
                writer.writeAnnotation(annotationEncodedValue.typeReference, annotationEncodedValue.elements);
                break;
            case ValueType.ARRAY:
                BuilderArrayEncodedValue arrayEncodedValue = (BuilderArrayEncodedValue) encodedValue;
                writer.writeArray(arrayEncodedValue.elements);
                break;
            case ValueType.BOOLEAN:
                writer.writeBoolean(((BooleanEncodedValue) encodedValue).getValue());
                break;
            case ValueType.BYTE:
                writer.writeByte(((ByteEncodedValue) encodedValue).getValue());
                break;
            case ValueType.CHAR:
                writer.writeChar(((CharEncodedValue) encodedValue).getValue());
                break;
            case ValueType.DOUBLE:
                writer.writeDouble(((DoubleEncodedValue) encodedValue).getValue());
                break;
            case ValueType.ENUM:
                writer.writeEnum(((BuilderEnumEncodedValue) encodedValue).getValue());
                break;
            case ValueType.FIELD:
                writer.writeField(((BuilderFieldEncodedValue) encodedValue).fieldReference);
                break;
            case ValueType.FLOAT:
                writer.writeFloat(((FloatEncodedValue) encodedValue).getValue());
                break;
            case ValueType.INT:
                writer.writeInt(((IntEncodedValue) encodedValue).getValue());
                break;
            case ValueType.LONG:
                writer.writeLong(((LongEncodedValue) encodedValue).getValue());
                break;
            case ValueType.METHOD:
                writer.writeMethod(((BuilderMethodEncodedValue) encodedValue).methodReference);
                break;
            case ValueType.NULL:
                writer.writeNull();
                break;
            case ValueType.SHORT:
                writer.writeShort(((ShortEncodedValue) encodedValue).getValue());
                break;
            case ValueType.STRING:
                writer.writeString(((BuilderStringEncodedValue) encodedValue).stringReference);
                break;
            case ValueType.TYPE:
                writer.writeType(((BuilderTypeEncodedValue) encodedValue).typeReference);
                break;
            default:
                throw new ExceptionWithContext("Unrecognized value type: %d", encodedValue.getValueType());
        }
    }

    /**
     * Add by Bin. 2016.10.05
     */

    private boolean ignoreMethodAndFieldError = false;

    public void setIgnoreMethodAndFieldError(boolean ignoreMethodAndFieldError) {
        this.ignoreMethodAndFieldError = ignoreMethodAndFieldError;
    }

    
    public BuilderClassDef internClassDef(ClassDef classDef) {
        ArrayList<BuilderField> fields = new ArrayList<>();
        ArrayList<BuilderMethod> methods = new ArrayList<>();
        if (ignoreMethodAndFieldError) {
            // Field
            for (Field field : classDef.getFields()) {
                try {
                    BuilderField builderField = internField(field.getDefiningClass(), field.getName(), field.getType(), field.getAccessFlags(),
                            field.getInitialValue(), field.getAnnotations());
                    fields.add(builderField);
                } catch (RuntimeException e) {
                    System.err.println(classDef.getType());
                    e.printStackTrace();
                }
            }
            // Method
            for (Method method : classDef.getMethods()) {
                try {
                    BuilderMethod builderMethod = internMethod(method.getDefiningClass(), method.getName(), method.getParameters(), method.getReturnType(),
                            method.getAccessFlags(), method.getAnnotations(), copyMethodImplementation(method.getImplementation()));
                    methods.add(builderMethod);
                } catch (RuntimeException e) {
                    System.err.println(classDef.getType());
                    e.printStackTrace();
                }
            }
        } else {
            // Field
            for (Field field : classDef.getFields()) {
                BuilderField builderField = internField(field.getDefiningClass(), field.getName(), field.getType(), field.getAccessFlags(),
                        field.getInitialValue(), field.getAnnotations());
                fields.add(builderField);
            }
            // Method
            for (Method method : classDef.getMethods()) {
                BuilderMethod builderMethod = internMethod(method.getDefiningClass(), method.getName(), method.getParameters(), method.getReturnType(),
                        method.getAccessFlags(), method.getAnnotations(), copyMethodImplementation(method.getImplementation()));
                methods.add(builderMethod);
            }
        }
        return internClassDef(classDef.getType(), classDef.getAccessFlags(),
                classDef.getSuperclass(), classDef.getInterfaces(), classDef.getSourceFile(),
                classDef.getAnnotations(), fields, methods);
    }

    private MethodImplementation copyMethodImplementation(MethodImplementation implementation) {
        MethodImplementation methodImplementation;
        if (implementation == null)
            methodImplementation = null;
        else {
            final int registerCount = implementation.getRegisterCount();
            final ArrayList<Instruction> instructions = new ArrayList<>();
            final ArrayList<BaseTryBlock<ExceptionHandler>> tryBlocks;
            final ArrayList<DebugItem> debugItems = new ArrayList<>();
            for (Instruction instruction : implementation.getInstructions()) {
                if (instruction instanceof UpdateReference)
                    ((UpdateReference) instruction).updateReference(this);
                instructions.add(instruction);
            }
            List<? extends TryBlock> tempTryBlocks = implementation.getTryBlocks();
            tryBlocks = new ArrayList<>(tempTryBlocks.size());
            for (TryBlock tryBlock : tempTryBlocks)
                tryBlocks.add(copyTryBlock(tryBlock));

            for (DebugItem debugItem : implementation.getDebugItems()) {
                if (debugItem instanceof UpdateReference)
                    ((UpdateReference) debugItem).updateReference(this);
                debugItems.add(debugItem);
            }

            methodImplementation = new MethodImplementation() {
                @Override
                public int getRegisterCount() {
                    return registerCount;
                }

                
                @Override
                public Iterable<? extends Instruction> getInstructions() {
                    return instructions;
                }

                
                @Override
                public List<? extends TryBlock<? extends ExceptionHandler>> getTryBlocks() {
                    return tryBlocks;
                }

                
                @Override
                public Iterable<? extends DebugItem> getDebugItems() {
                    return debugItems;
                }
            };
        }
        return methodImplementation;
    }

    private BaseTryBlock<ExceptionHandler> copyTryBlock(TryBlock tryBlock) {
        final int startCodeAddress = tryBlock.getStartCodeAddress();
        final int codeUnitCount = tryBlock.getCodeUnitCount();
        //noinspection unchecked
        List<ExceptionHandler> tempExceptionHandlers = tryBlock.getExceptionHandlers();
        final List<ExceptionHandler> exceptionHandlers = new ArrayList<>(tempExceptionHandlers.size());
        for (ExceptionHandler backedExceptionHandler : tempExceptionHandlers)
            exceptionHandlers.add(copyExceptionHandler(backedExceptionHandler));
        return new BaseTryBlock<ExceptionHandler>() {
            @Override
            public int getStartCodeAddress() {
                return startCodeAddress;
            }

            @Override
            public int getCodeUnitCount() {
                return codeUnitCount;
            }

            
            @Override
            public List<? extends ExceptionHandler> getExceptionHandlers() {
                return exceptionHandlers;
            }
        };
    }

    private ExceptionHandler copyExceptionHandler(ExceptionHandler exceptionHandler) {
        String exceptionType = exceptionHandler.getExceptionType();
        final TypeReference typeReference = exceptionType == null ? null : internTypeReference(exceptionType);
        final int handlerCodeAddress = exceptionHandler.getHandlerCodeAddress();
        return new BaseExceptionHandler() {

            @Override
            public TypeReference getExceptionTypeReference() {
                return typeReference;
            }


            @Override
            public String getExceptionType() {
                return typeReference == null ? null : typeReference.getType();
            }

            @Override
            public int getHandlerCodeAddress() {
                return handlerCodeAddress;
            }
        };
    }


    
    Set<? extends BuilderAnnotationElement> internAnnotationElements(
            Set<? extends AnnotationElement> elements) {
        return ImmutableSet.copyOf(
                Iterators.transform(elements.iterator(),
                        new Function<AnnotationElement, BuilderAnnotationElement>() {

                            @Override
                            public BuilderAnnotationElement apply(AnnotationElement input) {
                                return internAnnotationElement(input);
                            }
                        }));
    }

    
    private BuilderAnnotationElement internAnnotationElement(AnnotationElement annotationElement) {
        return new BuilderAnnotationElement(stringSection.internString(annotationElement.getName()),
                internEncodedValue(annotationElement.getValue()));
    }


    BuilderEncodedValue internNullableEncodedValue(EncodedValue encodedValue) {
        if (encodedValue == null) {
            return null;
        }
        return internEncodedValue(encodedValue);
    }

    
    private BuilderEncodedValue internEncodedValue(EncodedValue encodedValue) {
        switch (encodedValue.getValueType()) {
            case ValueType.ANNOTATION:
                return internAnnotationEncodedValue((AnnotationEncodedValue) encodedValue);
            case ValueType.ARRAY:
                return internArrayEncodedValue((ArrayEncodedValue) encodedValue);
            case ValueType.BOOLEAN:
                boolean value = ((BooleanEncodedValue) encodedValue).getValue();
                return value ? BuilderBooleanEncodedValue.TRUE_VALUE : BuilderBooleanEncodedValue.FALSE_VALUE;
            case ValueType.BYTE:
                return new BuilderByteEncodedValue(((ByteEncodedValue) encodedValue).getValue());
            case ValueType.CHAR:
                return new BuilderCharEncodedValue(((CharEncodedValue) encodedValue).getValue());
            case ValueType.DOUBLE:
                return new BuilderDoubleEncodedValue(((DoubleEncodedValue) encodedValue).getValue());
            case ValueType.ENUM:
                return internEnumEncodedValue((EnumEncodedValue) encodedValue);
            case ValueType.FIELD:
                return internFieldEncodedValue((FieldEncodedValue) encodedValue);
            case ValueType.FLOAT:
                return new BuilderFloatEncodedValue(((FloatEncodedValue) encodedValue).getValue());
            case ValueType.INT:
                return new BuilderIntEncodedValue(((IntEncodedValue) encodedValue).getValue());
            case ValueType.LONG:
                return new BuilderLongEncodedValue(((LongEncodedValue) encodedValue).getValue());
            case ValueType.METHOD:
                return internMethodEncodedValue((MethodEncodedValue) encodedValue);
            case ValueType.NULL:
                return BuilderNullEncodedValue.INSTANCE;
            case ValueType.SHORT:
                return new BuilderShortEncodedValue(((ShortEncodedValue) encodedValue).getValue());
            case ValueType.STRING:
                return internStringEncodedValue((StringEncodedValue) encodedValue);
            case ValueType.TYPE:
                return internTypeEncodedValue((TypeEncodedValue) encodedValue);
            default:
                throw new ExceptionWithContext("Unexpected encoded value type: %d", encodedValue.getValueType());
        }
    }

    
    private BuilderAnnotationEncodedValue internAnnotationEncodedValue(AnnotationEncodedValue value) {
        return new BuilderAnnotationEncodedValue(
                typeSection.internType(value.getType()),
                internAnnotationElements(value.getElements()));
    }

    
    private BuilderArrayEncodedValue internArrayEncodedValue(ArrayEncodedValue value) {
        return new BuilderArrayEncodedValue(
                ImmutableList.copyOf(
                        Iterators.transform(value.getValue().iterator(),
                                new Function<EncodedValue, BuilderEncodedValue>() {

                                    @Override
                                    public BuilderEncodedValue apply(EncodedValue input) {
                                        return internEncodedValue(input);
                                    }
                                })));
    }

    
    private BuilderEnumEncodedValue internEnumEncodedValue(EnumEncodedValue value) {
        return new BuilderEnumEncodedValue(fieldSection.internField(value.getValue()));
    }

    
    private BuilderFieldEncodedValue internFieldEncodedValue(FieldEncodedValue value) {
        return new BuilderFieldEncodedValue(fieldSection.internField(value.getValue()));
    }

    
    private BuilderMethodEncodedValue internMethodEncodedValue(MethodEncodedValue value) {
        return new BuilderMethodEncodedValue(methodSection.internMethod(value.getValue()));
    }

    
    private BuilderStringEncodedValue internStringEncodedValue(StringEncodedValue string) {
        return new BuilderStringEncodedValue(stringSection.internString(string.getValue()));
    }

    
    private BuilderTypeEncodedValue internTypeEncodedValue(TypeEncodedValue type) {
        return new BuilderTypeEncodedValue(typeSection.internType(type.getValue()));
    }

    protected class DexBuilderSectionProvider extends SectionProvider {
        
        @Override
        public BuilderStringPool getStringSection() {
            return new BuilderStringPool();
        }

        
        @Override
        public BuilderTypePool getTypeSection() {
            return new BuilderTypePool(DexBuilder.this);
        }

        
        @Override
        public BuilderProtoPool getProtoSection() {
            return new BuilderProtoPool(DexBuilder.this);
        }

        
        @Override
        public BuilderFieldPool getFieldSection() {
            return new BuilderFieldPool(DexBuilder.this);
        }

        
        @Override
        public BuilderMethodPool getMethodSection() {
            return new BuilderMethodPool(DexBuilder.this);
        }

        
        @Override
        public BuilderClassPool getClassSection() {
            return new BuilderClassPool(DexBuilder.this);
        }

        
        @Override
        public BuilderTypeListPool getTypeListSection() {
            return new BuilderTypeListPool(DexBuilder.this);
        }

        
        @Override
        public BuilderAnnotationPool getAnnotationSection() {
            return new BuilderAnnotationPool(DexBuilder.this);
        }

        
        @Override
        public BuilderAnnotationSetPool getAnnotationSetSection() {
            return new BuilderAnnotationSetPool(DexBuilder.this);
        }
    }
}
