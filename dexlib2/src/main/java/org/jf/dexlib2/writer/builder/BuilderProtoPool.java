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




import com.google.common.collect.Maps;

import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.immutable.reference.ImmutableMethodProtoReference;
import org.jf.dexlib2.util.MethodUtil;
import org.jf.dexlib2.writer.ProtoSection;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;

class BuilderProtoPool extends BaseBuilderPool
        implements ProtoSection<BuilderStringReference, BuilderTypeReference, BuilderMethodProtoReference, BuilderTypeList> {
    
    private final ConcurrentMap<MethodProtoReference, BuilderMethodProtoReference> internedItems =
            Maps.newConcurrentMap();

    public BuilderProtoPool(DexBuilder dexBuilder) {
        super(dexBuilder);
    }

    
    public BuilderMethodProtoReference internMethodProto(MethodProtoReference methodProto) {
        BuilderMethodProtoReference ret = internedItems.get(methodProto);
        if (ret != null) {
            return ret;
        }

        BuilderMethodProtoReference protoReference = new BuilderMethodProtoReference(
                dexBuilder.stringSection.internString(MethodUtil.getShorty(
                        methodProto.getParameterTypes(), methodProto.getReturnType())),
                dexBuilder.typeListSection.internTypeList(methodProto.getParameterTypes()),
                dexBuilder.typeSection.internType(methodProto.getReturnType()));
        ret = internedItems.putIfAbsent(protoReference, protoReference);
        return ret == null ? protoReference : ret;
    }

    
    public BuilderMethodProtoReference internMethodProto(MethodReference methodReference) {
        return internMethodProto(new ImmutableMethodProtoReference(
                methodReference.getParameterTypes(), methodReference.getReturnType()));
    }

    
    @Override
    public BuilderStringReference getShorty(BuilderMethodProtoReference proto) {
        return proto.shorty;
    }

    
    @Override
    public BuilderTypeReference getReturnType(BuilderMethodProtoReference proto) {
        return proto.returnType;
    }


    @Override
    public BuilderTypeList getParameters(BuilderMethodProtoReference proto) {
        return proto.parameterTypes;
    }

    @Override
    public int getItemIndex(BuilderMethodProtoReference proto) {
        return proto.getIndex();
    }

    
    @Override
    public Collection<? extends Entry<? extends BuilderMethodProtoReference, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderMethodProtoReference>(internedItems.values()) {
            @Override
            protected int getValue(BuilderMethodProtoReference key) {
                return key.index;
            }

            @Override
            protected int setValue(BuilderMethodProtoReference key, int value) {
                int prev = key.index;
                key.index = value;
                return prev;
            }
        };
    }

    @Override
    public int getItemCount() {
        return internedItems.size();
    }
}
