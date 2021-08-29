package com.mysoft.weather.exception;

import com.mysoft.weather.model.dto.MessageCode;

public enum ErrorEnum implements MessageCode {

    CITY_BLANK("10001", "city code can't be blank"),
    WEATHER_EMPTY_RESULT("10002", "weather result is empty"),
    READ_TIMEOUT("10003", "response timeout"),
    CONNECTION_TIMEOUT("10004", "connection timeout");

    private final String code;

    private final String message;

    private ErrorEnum(String code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String code() {
        return code;
    }
}
