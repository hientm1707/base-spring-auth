package vn.edu.hcmut.botp.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor(staticName = "of")
public class ErrorResponse {
    private final String message;
    private final HttpStatus httpStatus;
}
