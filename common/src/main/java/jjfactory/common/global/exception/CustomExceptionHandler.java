package jjfactory.common.global.exception;

import jjfactory.common.global.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception ex) {
        log.error("<<< error", ex);

        return ErrorResponse.builder()
                .message(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }
}
