package vn.edu.hcmut.botp.model.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vn.edu.hcmut.botp.model.constant.UserRole;

import java.util.Set;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class LoginResponse {
    private final String accessToken;
    private final String username;
    private final String email;
    private final Set<UserRole> roles;
}
