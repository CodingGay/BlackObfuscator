

package org.jf.dexlib2.immutable.instruction;




import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.SwitchElement;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.writer.InstructionFactory;

import java.util.List;

public class ImmutableInstructionFactory implements InstructionFactory<Reference> {
    public static final ImmutableInstructionFactory INSTANCE = new ImmutableInstructionFactory();

    private ImmutableInstructionFactory() {
    }

    public ImmutableInstruction10t makeInstruction10t(Opcode opcode,
                                                      int codeOffset) {
        return new ImmutableInstruction10t(opcode, codeOffset);
    }

    public ImmutableInstruction10x makeInstruction10x(Opcode opcode) {
        return new ImmutableInstruction10x(opcode);
    }

    public ImmutableInstruction11n makeInstruction11n(Opcode opcode,
                                                      int registerA,
                                                      int literal) {
        return new ImmutableInstruction11n(opcode, registerA, literal);
    }

    public ImmutableInstruction11x makeInstruction11x(Opcode opcode,
                                                      int registerA) {
        return new ImmutableInstruction11x(opcode, registerA);
    }

    public ImmutableInstruction12x makeInstruction12x(Opcode opcode,
                                                      int registerA,
                                                      int registerB) {
        return new ImmutableInstruction12x(opcode, registerA, registerB);
    }

    public ImmutableInstruction20bc makeInstruction20bc(Opcode opcode,
                                                        int verificationError,
                                                        Reference reference) {
        return new ImmutableInstruction20bc(opcode, verificationError, reference);
    }

    public ImmutableInstruction20t makeInstruction20t(Opcode opcode,
                                                      int codeOffset) {
        return new ImmutableInstruction20t(opcode, codeOffset);
    }

    public ImmutableInstruction21c makeInstruction21c(Opcode opcode,
                                                      int registerA,
                                                      Reference reference) {
        return new ImmutableInstruction21c(opcode, registerA, reference);
    }

    public ImmutableInstruction21ih makeInstruction21ih(Opcode opcode,
                                                        int registerA,
                                                        int literal) {
        return new ImmutableInstruction21ih(opcode, registerA, literal);
    }

    public ImmutableInstruction21lh makeInstruction21lh(Opcode opcode,
                                                        int registerA,
                                                        long literal) {
        return new ImmutableInstruction21lh(opcode, registerA, literal);
    }

    public ImmutableInstruction21s makeInstruction21s(Opcode opcode,
                                                      int registerA,
                                                      int literal) {
        return new ImmutableInstruction21s(opcode, registerA, literal);
    }

    public ImmutableInstruction21t makeInstruction21t(Opcode opcode,
                                                      int registerA,
                                                      int codeOffset) {
        return new ImmutableInstruction21t(opcode, registerA, codeOffset);
    }

    public ImmutableInstruction22b makeInstruction22b(Opcode opcode,
                                                      int registerA,
                                                      int registerB,
                                                      int literal) {
        return new ImmutableInstruction22b(opcode, registerA, registerB, literal);
    }

    public ImmutableInstruction22c makeInstruction22c(Opcode opcode,
                                                      int registerA,
                                                      int registerB,
                                                      Reference reference) {
        return new ImmutableInstruction22c(opcode, registerA, registerB, reference);
    }

    public ImmutableInstruction22s makeInstruction22s(Opcode opcode,
                                                      int registerA,
                                                      int registerB,
                                                      int literal) {
        return new ImmutableInstruction22s(opcode, registerA, registerB, literal);
    }

    public ImmutableInstruction22t makeInstruction22t(Opcode opcode,
                                                      int registerA,
                                                      int registerB,
                                                      int codeOffset) {
        return new ImmutableInstruction22t(opcode, registerA, registerB, codeOffset);
    }

    public ImmutableInstruction22x makeInstruction22x(Opcode opcode,
                                                      int registerA,
                                                      int registerB) {
        return new ImmutableInstruction22x(opcode, registerA, registerB);
    }

    public ImmutableInstruction23x makeInstruction23x(Opcode opcode,
                                                      int registerA,
                                                      int registerB,
                                                      int registerC) {
        return new ImmutableInstruction23x(opcode, registerA, registerB, registerC);
    }

    public ImmutableInstruction30t makeInstruction30t(Opcode opcode,
                                                      int codeOffset) {
        return new ImmutableInstruction30t(opcode, codeOffset);
    }

    public ImmutableInstruction31c makeInstruction31c(Opcode opcode,
                                                      int registerA,
                                                      Reference reference) {
        return new ImmutableInstruction31c(opcode, registerA, reference);
    }

    public ImmutableInstruction31i makeInstruction31i(Opcode opcode,
                                                      int registerA,
                                                      int literal) {
        return new ImmutableInstruction31i(opcode, registerA, literal);
    }

    public ImmutableInstruction31t makeInstruction31t(Opcode opcode,
                                                      int registerA,
                                                      int codeOffset) {
        return new ImmutableInstruction31t(opcode, registerA, codeOffset);
    }

    public ImmutableInstruction32x makeInstruction32x(Opcode opcode,
                                                      int registerA,
                                                      int registerB) {
        return new ImmutableInstruction32x(opcode, registerA, registerB);
    }

    public ImmutableInstruction35c makeInstruction35c(Opcode opcode,
                                                      int registerCount,
                                                      int registerC,
                                                      int registerD,
                                                      int registerE,
                                                      int registerF,
                                                      int registerG,
                                                      Reference reference) {
        return new ImmutableInstruction35c(opcode, registerCount, registerC, registerD, registerE, registerF, registerG,
                reference);
    }

    public ImmutableInstruction3rc makeInstruction3rc(Opcode opcode,
                                                      int startRegister,
                                                      int registerCount,
                                                      Reference reference) {
        return new ImmutableInstruction3rc(opcode, startRegister, registerCount, reference);
    }

    public ImmutableInstruction51l makeInstruction51l(Opcode opcode,
                                                      int registerA,
                                                      long literal) {
        return new ImmutableInstruction51l(opcode, registerA, literal);
    }

    public ImmutableSparseSwitchPayload makeSparseSwitchPayload(List<? extends SwitchElement> switchElements) {
        return new ImmutableSparseSwitchPayload(switchElements);
    }

    public ImmutablePackedSwitchPayload makePackedSwitchPayload(List<? extends SwitchElement> switchElements) {
        return new ImmutablePackedSwitchPayload(switchElements);
    }

    public ImmutableArrayPayload makeArrayPayload(int elementWidth,
                                                  List<Number> arrayElements) {
        return new ImmutableArrayPayload(elementWidth, arrayElements);
    }
}
