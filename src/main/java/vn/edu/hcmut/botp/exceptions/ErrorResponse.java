package vn.edu.hcmut.botp.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class ErrorResponse {
    private final String message;
    private final int code;
}
