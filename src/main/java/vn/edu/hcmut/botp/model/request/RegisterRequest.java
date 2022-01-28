package vn.edu.hcmut.botp.model.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterRequest {
    private final String username;
    private final String password;
}
