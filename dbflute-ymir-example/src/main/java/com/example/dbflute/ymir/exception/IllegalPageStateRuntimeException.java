package com.example.dbflute.ymir.exception;

public class IllegalPageStateRuntimeException extends
    ApplicationRuntimeException {

    private static final long serialVersionUID = 1L;

    public IllegalPageStateRuntimeException() {
    }

    public IllegalPageStateRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalPageStateRuntimeException(String message) {
        super(message);
    }

    public IllegalPageStateRuntimeException(Throwable cause) {
        super(cause);
    }
}
