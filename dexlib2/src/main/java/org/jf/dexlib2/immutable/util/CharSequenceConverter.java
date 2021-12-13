

package org.jf.dexlib2.immutable.util;




import com.google.common.collect.ImmutableList;

import org.jf.util.ImmutableConverter;

public final class CharSequenceConverter {
    private CharSequenceConverter() {
    }


    public static ImmutableList<String> immutableStringList(Iterable<? extends CharSequence> iterable) {
        return CONVERTER.toList(iterable);
    }

    private static final ImmutableConverter<String, CharSequence> CONVERTER =
            new ImmutableConverter<String, CharSequence>() {
                @Override
                protected boolean isImmutable(CharSequence item) {
                    return item instanceof String;
                }


                @Override
                protected String makeImmutable(CharSequence item) {
                    return item.toString();
                }
            };
}
