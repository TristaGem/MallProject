package com.example.gulimall.product.exception;

import com.example.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/*
 The central component that handles all exception
 */
//@ControllerAdvice(basePackages = "com.example.gulimall.product.controller")
//@ResponseBody
@RestControllerAdvice(basePackages = "com.example.gulimall.product.controller")
@Slf4j
public class GulimallExceptionControllerAdvice {

    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    @ResponseBody
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("The brand data validation throws exception, type{}, message{}", e.getClass(), e.getMessage());
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> map = new HashMap<>();
        bindingResult.getFieldErrors().forEach((item) -> {
            String message = item.getDefaultMessage();
            String field = item.getField();
            map.put(field, message);
        });
        return R.error(400, "The brand input data is invalid").put("data", map);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Exception e) {
        return R.error(400, "Exception has been thrown").put("data", e);
    }


}
