package com.mysoft.weather.config;

import com.mysoft.weather.exception.BuzzException;
import com.mysoft.weather.exception.ErrorEnum;
import com.mysoft.weather.model.dto.AnswerDTO;
import com.mysoft.weather.model.dto.BaseMessageCode;
import com.mysoft.weather.model.vo.GlobalErrorVO;
import com.mysoft.weather.util.http.ResponseFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

@ControllerAdvice
public class BuzzExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = BuzzException.class)
    public ResponseEntity<AnswerDTO<GlobalErrorVO>> handleFizzBuzzException(BuzzException exception) {
        return ResponseFactory.failed(HttpStatus.INTERNAL_SERVER_ERROR, exception.getCode(), exception.getMessage());
    }

}
