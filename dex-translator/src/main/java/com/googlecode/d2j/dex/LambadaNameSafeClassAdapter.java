package com.googlecode.d2j.dex;

import org.objectweb.asm2.ClassVisitor;
import org.objectweb.asm2.commons.Remapper;
import org.objectweb.asm2.commons.RemappingClassAdapter;

public class LambadaNameSafeClassAdapter extends RemappingClassAdapter {
    public String getClassName() {
        return remapper.mapType(className);
    }

    public LambadaNameSafeClassAdapter(ClassVisitor cv) {
        super(cv, new Remapper() {
            @Override
            public String mapType(String type) {
                if (type == null) {
                    return null;
                }
//                return type.replace('-', '_');
                return type;
            }
        });
    }
}
