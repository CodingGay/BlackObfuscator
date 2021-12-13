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

package org.jf.dexlib2.builder.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.UpdateReference;
import org.jf.dexlib2.iface.instruction.formats.Instruction35c;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.util.Preconditions;
import org.jf.dexlib2.writer.builder.DexBuilder;

public class BuilderInstruction35c extends BuilderInstruction implements Instruction35c, UpdateReference {
    public static final Format FORMAT = Format.Format35c;

    protected final int registerCount;
    protected final int registerC;
    protected final int registerD;
    protected final int registerE;
    protected final int registerF;
    protected final int registerG;
    
    protected Reference reference;

    public BuilderInstruction35c(Opcode opcode,
                                 int registerCount,
                                 int registerC,
                                 int registerD,
                                 int registerE,
                                 int registerF,
                                 int registerG,
                                 Reference reference) {
        super(opcode);
        this.registerCount = Preconditions.check35cAnd45ccRegisterCount(registerCount);
        this.registerC = (registerCount > 0) ? Preconditions.checkNibbleRegister(registerC) : 0;
        this.registerD = (registerCount > 1) ? Preconditions.checkNibbleRegister(registerD) : 0;
        this.registerE = (registerCount > 2) ? Preconditions.checkNibbleRegister(registerE) : 0;
        this.registerF = (registerCount > 3) ? Preconditions.checkNibbleRegister(registerF) : 0;
        this.registerG = (registerCount > 4) ? Preconditions.checkNibbleRegister(registerG) : 0;
        this.reference = reference;
//        checkItem(opcode, reference, registerCount);
    }

//    private static void checkItem(Opcode opcode, Reference item, int regCount) {
//        if (opcode == FILLED_NEW_ARRAY) {
//            //check data for filled-new-array opcode
//            String type = ((TypeReference) item).getType();
//            if (type.charAt(0) != '[') {
//                throw new RuntimeException("The type must be an array type");
//            }
//            if (type.charAt(1) == 'J' || type.charAt(1) == 'D') {
//                throw new RuntimeException("The type cannot be an array of longs or doubles");
//            }
//        } else if (opcode == INVOKE_VIRTUAL || opcode == INVOKE_SUPER || opcode == INVOKE_DIRECT
//                || opcode == INVOKE_STATIC  || opcode == INVOKE_INTERFACE) {
//            //check data for invoke-* opcodes
//            MethodReference methodIdItem = (MethodReference) item;
//            int parameterRegisterCount = methodIdItem.getParameterTypes().size();
//            if (opcode != INVOKE_STATIC) {
//                parameterRegisterCount++;
//            }
//            if (parameterRegisterCount != regCount) {
//                throw new RuntimeException("regCount does not match the number of arguments of the method " + parameterRegisterCount);
//            }
//        }
//    }

    @Override
    public int getRegisterCount() {
        return registerCount;
    }

    @Override
    public int getRegisterC() {
        return registerC;
    }

    @Override
    public int getRegisterD() {
        return registerD;
    }

    @Override
    public int getRegisterE() {
        return registerE;
    }

    @Override
    public int getRegisterF() {
        return registerF;
    }

    @Override
    public int getRegisterG() {
        return registerG;
    }

    
    @Override
    public Reference getReference() {
        return reference;
    }

    @Override
    public int getReferenceType() {
        return opcode.referenceType;
    }

    @Override
    public Format getFormat() {
        return FORMAT;
    }

    @Override
    public void updateReference(DexBuilder dexBuilder) {
        this.reference = dexBuilder.internReference(getReference());
    }
}
