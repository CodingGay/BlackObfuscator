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

package org.jf.dexlib2.dexbacked.instruction;



import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.ReferenceType;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.reference.DexBackedReference;
import org.jf.dexlib2.iface.UpdateReference;
import org.jf.dexlib2.iface.instruction.formats.Instruction20bc;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.writer.builder.DexBuilder;

public class DexBackedInstruction20bc extends DexBackedInstruction implements Instruction20bc, UpdateReference {
    public DexBackedInstruction20bc(DexBackedDexFile dexFile,
                                    Opcode opcode,
                                    int instructionStart) {
        super(dexFile, opcode, instructionStart);
    }

    @Override
    public int getVerificationError() {
        return dexFile.readUbyte(instructionStart + 1) & 0x3f;
    }


    @Override
    public Reference getReference() {
        if (reference != null)
            return reference;
        int referenceType = getReferenceType();
        return DexBackedReference.makeReference(dexFile, referenceType, dexFile.readUshort(instructionStart + 2));
    }

    @Override
    public int getReferenceType() {
        int referenceType = this.referenceType;
        if (referenceType != -1)
            return referenceType;
        referenceType = (dexFile.readUbyte(instructionStart + 1) >>> 6) + 1;
        ReferenceType.validateReferenceType(referenceType);
        return this.referenceType = referenceType;
    }

    private Reference reference = null;
    private int referenceType = -1;

    @Override
    public void updateReference(DexBuilder dexBuilder) {
        this.reference = dexBuilder.internReference(getReference());
    }

}