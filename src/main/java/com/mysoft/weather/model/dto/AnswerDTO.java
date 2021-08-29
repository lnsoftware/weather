package com.mysoft.weather.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnswerDTO<T>  implements Serializable {

    private MessageDTO message;

    private T content;

    public AnswerDTO(MessageDTO message, T content) {
        this.message = message;
        this.content = content;
    }

    public AnswerDTO(MessageDTO message) {
        this.message = message;
    }

    public AnswerDTO() {
    }
}
