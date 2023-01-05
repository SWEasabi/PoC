package com.SWEasabi.mqttdemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class LampNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(LampNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String LampNotFoundHandler(LampNotFoundException ex) {
    return ex.getMessage();
  }
}