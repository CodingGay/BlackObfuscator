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

package org.jf.dexlib2.writer;




import org.jf.dexlib2.builder.MutableMethodImplementation;
import org.jf.dexlib2.iface.ExceptionHandler;
import org.jf.dexlib2.iface.TryBlock;
import org.jf.dexlib2.iface.debug.DebugItem;
import org.jf.dexlib2.iface.instruction.Instruction;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ClassSection<StringKey extends CharSequence, TypeKey extends CharSequence, TypeListKey, ClassKey,
        FieldKey, MethodKey, AnnotationSetKey, EncodedValue> extends IndexSection<ClassKey> {

    Collection<? extends ClassKey> getSortedClasses();


    Map.Entry<? extends ClassKey, Integer> getClassEntryByType(TypeKey key);


    TypeKey getType(ClassKey key);

    int getAccessFlags(ClassKey key);


    TypeKey getSuperclass(ClassKey key);


    TypeListKey getInterfaces(ClassKey key);


    StringKey getSourceFile(ClassKey key);


    Collection<? extends EncodedValue> getStaticInitializers(ClassKey key);


    Collection<? extends FieldKey> getSortedStaticFields(ClassKey key);


    Collection<? extends FieldKey> getSortedInstanceFields(ClassKey key);


    Collection<? extends FieldKey> getSortedFields(ClassKey key);


    Collection<? extends MethodKey> getSortedDirectMethods(ClassKey key);


    Collection<? extends MethodKey> getSortedVirtualMethods(ClassKey key);


    Collection<? extends MethodKey> getSortedMethods(ClassKey key);

    int getFieldAccessFlags(FieldKey key);

    int getMethodAccessFlags(MethodKey key);


    AnnotationSetKey getClassAnnotations(ClassKey key);


    AnnotationSetKey getFieldAnnotations(FieldKey key);


    AnnotationSetKey getMethodAnnotations(MethodKey key);


    List<? extends AnnotationSetKey> getParameterAnnotations(MethodKey key);


    Iterable<? extends DebugItem> getDebugItems(MethodKey key);


    Iterable<? extends StringKey> getParameterNames(MethodKey key);

    int getRegisterCount(MethodKey key);


    Iterable<? extends Instruction> getInstructions(MethodKey key);


    List<? extends TryBlock<? extends ExceptionHandler>> getTryBlocks(MethodKey key);


    TypeKey getExceptionType(ExceptionHandler handler);


    MutableMethodImplementation makeMutableMethodImplementation(MethodKey key);

    void setEncodedArrayOffset(ClassKey key, int offset);

    int getEncodedArrayOffset(ClassKey key);

    void setAnnotationDirectoryOffset(ClassKey key, int offset);

    int getAnnotationDirectoryOffset(ClassKey key);

    void setAnnotationSetRefListOffset(MethodKey key, int offset);

    int getAnnotationSetRefListOffset(MethodKey key);

    void setCodeItemOffset(MethodKey key, int offset);

    int getCodeItemOffset(MethodKey key);

    void writeDebugItem(DebugWriter<StringKey, TypeKey> writer, DebugItem debugItem) throws IOException;
}
