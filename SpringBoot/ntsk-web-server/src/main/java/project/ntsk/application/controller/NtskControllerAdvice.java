package project.ntsk.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import project.ntsk.common.exception.NtskException;
import project.ntsk.domain.model.api.NtskErrorRes;

@Slf4j
@RestControllerAdvice
public class NtskControllerAdvice {

    @ExceptionHandler({NtskException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public NtskErrorRes handleNtskException(NtskException e) {
        log.error("Error:", e.getMessage());
        return new NtskErrorRes(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public NtskErrorRes handleException(Exception e) {
        log.error("Error:", e.getMessage());
        return new NtskErrorRes(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), e.getMessage());
    }

}
