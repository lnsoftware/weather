package com.mysoft.weather.model.dto;

public enum BaseMessageCode implements MessageCode {
    OK("200"),
    ERROR("500");

    private final String code;

    BaseMessageCode(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return code;
    }

}