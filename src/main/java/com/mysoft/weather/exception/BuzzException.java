package com.mysoft.weather.exception;

public class BuzzException extends RuntimeException {

    private final String code;

    private final String message;

    public BuzzException(ErrorEnum errorEnum) {
        this.code = errorEnum.getCode();
        this.message = errorEnum.getMessage();
    }

    public BuzzException(String message, String code, String message1) {
        this.code = code;
        this.message = message1;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
