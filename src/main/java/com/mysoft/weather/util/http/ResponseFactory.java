package com.mysoft.weather.util.http;

import com.mysoft.weather.model.dto.AnswerDTO;
import com.mysoft.weather.model.dto.MessageCode;
import com.mysoft.weather.model.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class ResponseFactory {

    public static <T> ResponseEntity<AnswerDTO<T>> success(HttpStatus status, T content) {
        AnswerDTO<T> answer = new AnswerDTO<>(MessageDTO.okInstance(), content);
        return create(answer, status);
    }

    public static <T> ResponseEntity<AnswerDTO<T>> success(HttpStatus status) {
        AnswerDTO<T> answer = new AnswerDTO<T>(MessageDTO.okInstance());
        return create(answer, status);
    }

    public static <T> ResponseEntity<AnswerDTO<T>> success() {
        AnswerDTO<T> answer = new AnswerDTO<T>(MessageDTO.okInstance());
        return create(answer, HttpStatus.OK);
    }

    public static <T> ResponseEntity<AnswerDTO<T>> updateSuccess() {
        AnswerDTO<T> answer = new AnswerDTO<T>(MessageDTO.okInstance());
        return create(answer, HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<AnswerDTO<T>> deleteSuccess() {
        AnswerDTO<T> answer = new AnswerDTO<T>(MessageDTO.okInstance());
        return create(answer, HttpStatus.NO_CONTENT);
    }

    public static <T> ResponseEntity<AnswerDTO<T>> failed(HttpStatus status, MessageCode messageCode, String errorMessage) {
        AnswerDTO<T> answer = new AnswerDTO<>(MessageDTO.failedInstance(messageCode, errorMessage));
        return create(answer, status);
    }

    public static <T> ResponseEntity<AnswerDTO<T>> failed(HttpStatus status, String messageCode, String errorMessage) {
        AnswerDTO<T> answer = new AnswerDTO<>(MessageDTO.failedInstance(messageCode, errorMessage));
        return create(answer, status);
    }

    public static <T> ResponseEntity<AnswerDTO<T>> failed(HttpStatus status, MessageCode messageCode, String errorMessage, T content) {
        AnswerDTO<T> answer = new AnswerDTO<>(MessageDTO.failedInstance(messageCode, errorMessage), content);
        return create(answer, status);
    }

    public static <T> ResponseEntity<AnswerDTO<T>> failed(HttpStatus status, String messageCode, String errorMessage, T content) {
        AnswerDTO<T> answer = new AnswerDTO<>(MessageDTO.failedInstance(messageCode, errorMessage), content);
        return create(answer, status);
    }

    private static <T> ResponseEntity<AnswerDTO<T>> create(AnswerDTO<T> answer, HttpStatus status) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        return new ResponseEntity<>(answer, headers, status);
    }

}
