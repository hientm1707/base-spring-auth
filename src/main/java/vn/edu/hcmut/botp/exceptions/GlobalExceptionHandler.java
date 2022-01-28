package vn.edu.hcmut.botp.exceptions;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Data
@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(value = {Exception.class})
    public ErrorResponse handleCommonException(Exception e) {
        log.info("Caught an unexpected exception: {}", e.getMessage());
        return ErrorResponse.of(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(value = {BadCredentialsException.class})
    public ErrorResponse handleCommonException(BadCredentialsException e) {
        log.info("{}", e.getMessage());
        return ErrorResponse.of(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
}
