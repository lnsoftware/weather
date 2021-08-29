package com.mysoft.weather.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageDTO implements Serializable {

    /** The value is used for message description. */
    private String message;

    /** Message code like NOT_FOUND. */
    private String messageCode;


    public MessageDTO(String message, String messageCode) {
        this.message = message;
        this.messageCode = messageCode;
    }

    public MessageDTO(String message, MessageCode messageCode) {
        this.message = message;
        this.messageCode = messageCode.code();
    }

    public MessageDTO() {
    }

    public static MessageDTO okInstance() {
        return new MessageDTO("OK", BaseMessageCode.OK.code());
    }


    public static MessageDTO failedInstance(MessageCode messageCode, String errorMessage) {
        return new MessageDTO(errorMessage, messageCode.code());
    }

    public static MessageDTO failedInstance(String messageCode, String errorMessage) {
        return new MessageDTO(errorMessage, messageCode);
    }

}
