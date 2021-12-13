

package org.jf.dexlib2.immutable;




import com.google.common.collect.ImmutableList;

import org.jf.dexlib2.base.BaseExceptionHandler;
import org.jf.dexlib2.iface.ExceptionHandler;
import org.jf.util.ImmutableConverter;

public class ImmutableExceptionHandler extends BaseExceptionHandler implements ExceptionHandler {

    protected final String exceptionType;
    protected final int handlerCodeAddress;

    public ImmutableExceptionHandler(String exceptionType,
                                     int handlerCodeAddress) {
        this.exceptionType = exceptionType;
        this.handlerCodeAddress = handlerCodeAddress;
    }

    public static ImmutableExceptionHandler of(ExceptionHandler exceptionHandler) {
        if (exceptionHandler instanceof ImmutableExceptionHandler) {
            return (ImmutableExceptionHandler) exceptionHandler;
        }
        return new ImmutableExceptionHandler(
                exceptionHandler.getExceptionType(),
                exceptionHandler.getHandlerCodeAddress());
    }


    @Override
    public String getExceptionType() {
        return exceptionType;
    }

    @Override
    public int getHandlerCodeAddress() {
        return handlerCodeAddress;
    }


    public static ImmutableList<ImmutableExceptionHandler> immutableListOf(
            Iterable<? extends ExceptionHandler> list) {
        return CONVERTER.toList(list);
    }

    private static final ImmutableConverter<ImmutableExceptionHandler, ExceptionHandler> CONVERTER =
            new ImmutableConverter<ImmutableExceptionHandler, ExceptionHandler>() {
                @Override
                protected boolean isImmutable(ExceptionHandler item) {
                    return item instanceof ImmutableExceptionHandler;
                }


                @Override
                protected ImmutableExceptionHandler makeImmutable(ExceptionHandler item) {
                    return ImmutableExceptionHandler.of(item);
                }
            };
}
