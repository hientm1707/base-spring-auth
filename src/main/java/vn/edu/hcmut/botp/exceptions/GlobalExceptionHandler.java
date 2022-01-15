package vn.edu.hcmut.botp.exceptions;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@Getter
public class GlobalExceptionHandler {


    @ExceptionHandler(value = {Exception.class})
    public ErrorResponse handleCommonException(Exception e) {
        log.info("Caught an unexpected exception {}", e.getMessage());
        return ErrorResponse.of(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
