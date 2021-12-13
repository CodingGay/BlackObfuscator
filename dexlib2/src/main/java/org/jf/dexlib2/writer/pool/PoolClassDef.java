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

package org.jf.dexlib2.writer.pool;




import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;

import org.jf.dexlib2.base.reference.BaseTypeReference;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.Field;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

class PoolClassDef extends BaseTypeReference implements ClassDef {

    final ClassDef classDef;

    final TypeListPool.Key<List<String>> interfaces;

    final ImmutableSortedSet<Field> staticFields;

    final ImmutableSortedSet<Field> instanceFields;

    final ImmutableSortedSet<PoolMethod> directMethods;

    final ImmutableSortedSet<PoolMethod> virtualMethods;

    int classDefIndex = DexPool.NO_INDEX;
    int encodedArrayOffset = DexPool.NO_OFFSET;
    int annotationDirectoryOffset = DexPool.NO_OFFSET;

    PoolClassDef(ClassDef classDef) {
        this.classDef = classDef;

        interfaces = new TypeListPool.Key<List<String>>(ImmutableList.copyOf(classDef.getInterfaces()));
        staticFields = ImmutableSortedSet.copyOf(classDef.getStaticFields());
        instanceFields = ImmutableSortedSet.copyOf(classDef.getInstanceFields());
        directMethods = ImmutableSortedSet.copyOf(
                Iterables.transform(classDef.getDirectMethods(), PoolMethod.TRANSFORM));
        virtualMethods = ImmutableSortedSet.copyOf(
                Iterables.transform(classDef.getVirtualMethods(), PoolMethod.TRANSFORM));
    }


    @Override
    public String getType() {
        return classDef.getType();
    }

    @Override
    public int getAccessFlags() {
        return classDef.getAccessFlags();
    }


    @Override
    public String getSuperclass() {
        return classDef.getSuperclass();
    }


    @Override
    public List<String> getInterfaces() {
        return interfaces.types;
    }


    @Override
    public String getSourceFile() {
        return classDef.getSourceFile();
    }


    @Override
    public Set<? extends Annotation> getAnnotations() {
        return classDef.getAnnotations();
    }


    @Override
    public SortedSet<Field> getStaticFields() {
        return staticFields;
    }


    @Override
    public SortedSet<Field> getInstanceFields() {
        return instanceFields;
    }


    @Override
    public Collection<Field> getFields() {
        return new AbstractCollection<Field>() {

            @Override
            public Iterator<Field> iterator() {
                return Iterators.mergeSorted(
                        ImmutableList.of(staticFields.iterator(), instanceFields.iterator()),
                        Ordering.natural());
            }

            @Override
            public int size() {
                return staticFields.size() + instanceFields.size();
            }
        };
    }


    @Override
    public SortedSet<PoolMethod> getDirectMethods() {
        return directMethods;
    }


    @Override
    public SortedSet<PoolMethod> getVirtualMethods() {
        return virtualMethods;
    }


    @Override
    public Collection<PoolMethod> getMethods() {
        return new AbstractCollection<PoolMethod>() {

            @Override
            public Iterator<PoolMethod> iterator() {
                return Iterators.mergeSorted(
                        ImmutableList.of(directMethods.iterator(), virtualMethods.iterator()),
                        Ordering.natural());
            }

            @Override
            public int size() {
                return directMethods.size() + virtualMethods.size();
            }
        };
    }
}
