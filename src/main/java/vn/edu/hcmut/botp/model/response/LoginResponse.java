package vn.edu.hcmut.botp.model.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class LoginResponse {
    private final String jwtHere;
}
