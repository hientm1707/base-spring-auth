package vn.edu.hcmut.botp.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvalidCredentialsException extends RuntimeException{
    private final String message = "Invalid Credentials";
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
