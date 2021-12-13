/*
 * Copyright 2012, Google Inc.
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

package org.jf.dexlib2.iface.reference;




/**
 * This class represents a reference to a type.
 * <p>
 * When possible, elsewhere in the interface, a type is referenced directly as a String. A TypeReference is only used
 * in those cases where a generic Reference is needed
 * <p>
 * The type being referenced is represented as a String in the format of a TypeDescriptor, as defined by the dex file
 * specification.
 * <p>
 * This type also acts as a CharSequence wrapper around the TypeDescriptor string. As per the CharSequence contract,
 * calling toString() on a TypeReference yields the type descriptor as a String. This is the same value returned by
 * getType()
 */
public interface TypeReference extends Reference, CharSequence, Comparable<CharSequence> {
    /**
     * Gets the string representation of the referenced type.
     * <p>
     * The returned string will be a TypeDescriptor, as defined in the dex file specification
     *
     * @return The string representation of the referenced type.
     */

    String getType();

    /**
     * Returns a hashcode for this TypeReference.
     * <p>
     * This is defined to be getType().hashCode()
     *
     * @return The hash code value for this TypeReference
     */
    @Override
    int hashCode();

    /**
     * Compares this TypeReference to another TypeReference, or more generally to another CharSequence for equality.
     * <p>
     * This TypeReference is equal to a CharSequence iff this.getType().equals(other.toString()).
     * <p>
     * Equivalently, This TypeReference is equal to another TypeReference iff this.getType().equals(other.getType()).
     *
     * @param o The object to be compared for equality with this TypeReference
     * @return true if the specified object is equal to this TypeReference
     */
    @Override
    boolean equals(Object o);

    /**
     * Compare this TypeReference to another TypeReference, or more generally to another CharSequence.
     * <p>
     * The comparison is defined to be this.getType().compareTo(other.toString())
     *
     * @param o The CharSequence to compare with this TypeReference
     * @return An integer representing the result of the comparison
     */
    @Override
    int compareTo(CharSequence o);
}
