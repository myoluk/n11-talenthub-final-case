package com.myoluk.exception;

import com.myoluk.config.KafkaProperties;
import com.myoluk.enums.EnumLogLevel;
import com.myoluk.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final KafkaProducerService kafkaProducerService;

    private final KafkaProperties kafkaProperties;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {

        kafkaProducerService.sendMessage(
                kafkaProperties.getTopic(),
                kafkaProperties.getService(),
                EnumLogLevel.ERROR.toString(),
                e.getMessage());

        String errorMessage = EnumLogLevel.ERROR + " : " + e.getMessage();

        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
