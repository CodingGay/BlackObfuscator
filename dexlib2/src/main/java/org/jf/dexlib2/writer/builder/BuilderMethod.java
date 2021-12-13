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




import org.jf.dexlib2.base.reference.BaseMethodReference;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.writer.DexWriter;

import java.util.List;

public class BuilderMethod extends BaseMethodReference implements Method {

    final BuilderMethodReference methodReference;

    final List<? extends BuilderMethodParameter> parameters;
    final int accessFlags;

    final BuilderAnnotationSet annotations;

    final MethodImplementation methodImplementation;

    int annotationSetRefListOffset = DexWriter.NO_OFFSET;
    int codeItemOffset = DexWriter.NO_OFFSET;

    BuilderMethod(BuilderMethodReference methodReference,
                  List<? extends BuilderMethodParameter> parameters,
                  int accessFlags,
                  BuilderAnnotationSet annotations,
                  MethodImplementation methodImplementation) {
        this.methodReference = methodReference;
        this.parameters = parameters;
        this.accessFlags = accessFlags;
        this.annotations = annotations;
        this.methodImplementation = methodImplementation;
    }

    @Override

    public String getDefiningClass() {
        return methodReference.definingClass.getType();
    }

    @Override

    public String getName() {
        return methodReference.name.getString();
    }

    @Override

    public BuilderTypeList getParameterTypes() {
        return methodReference.proto.parameterTypes;
    }


    @Override
    public String getReturnType() {
        return methodReference.proto.returnType.getType();
    }

    @Override

    public List<? extends BuilderMethodParameter> getParameters() {
        return parameters;
    }

    @Override
    public int getAccessFlags() {
        return accessFlags;
    }

    @Override

    public BuilderAnnotationSet getAnnotations() {
        return annotations;
    }

    @Override

    public MethodImplementation getImplementation() {
        return methodImplementation;
    }
}
