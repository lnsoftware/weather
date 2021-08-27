package com.mysoft.weather.exception;

public enum ErrorEnum {
    CITY_BLANK("city blank", "city code can't be blank"),
    WEATHER_EMPTY_RESULT("empty result", "weather result is empty");

    private final String message;

    private final String reason;

    private ErrorEnum(String message, String reason) {
        this.message = message;
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public String getReason() {
        return reason;
    }
}
