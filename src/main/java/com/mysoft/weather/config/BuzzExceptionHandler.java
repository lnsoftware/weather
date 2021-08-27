package com.mysoft.weather.config;

import com.mysoft.weather.exception.BuzzException;
import com.mysoft.weather.model.vo.GlobalErrorVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BuzzExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = BuzzException.class)
    public ResponseEntity<GlobalErrorVO> handleFizzBuzzException(BuzzException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GlobalErrorVO(exception.getMessage(), exception.getErrorReason()));
    }

//    @ResponseBody
//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<GlobalErrorVO> handleFizzBuzzException(Exception exception) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GlobalErrorVO(exception.getMessage(), exception.getMessage()));
//    }
}
