

package org.jf.dexlib2.immutable.util;



import org.jf.dexlib2.immutable.ImmutableMethodParameter;

import java.util.Iterator;

public class ParamUtil {
    private static int findTypeEnd(String str, int index) {
        char c = str.charAt(index);
        switch (c) {
            case 'Z':
            case 'B':
            case 'S':
            case 'C':
            case 'I':
            case 'J':
            case 'F':
            case 'D':
                return index + 1;
            case 'L':
                while (str.charAt(index++) != ';') {
                }
                return index;
            case '[':
                while (str.charAt(index++) != '[') {
                }
                return findTypeEnd(str, index);
            default:
                throw new IllegalArgumentException(String.format("Param string \"%s\" contains invalid type prefix: %s",
                        str, Character.toString(c)));
        }
    }


    public static Iterable<ImmutableMethodParameter> parseParamString(final String params) {
        return new Iterable<ImmutableMethodParameter>() {
            @Override
            public Iterator<ImmutableMethodParameter> iterator() {
                return new Iterator<ImmutableMethodParameter>() {

                    private int index = 0;

                    @Override
                    public boolean hasNext() {
                        return index < params.length();
                    }

                    @Override
                    public ImmutableMethodParameter next() {
                        int end = findTypeEnd(params, index);
                        String ret = params.substring(index, end);
                        index = end;
                        return new ImmutableMethodParameter(ret, null, null);
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
