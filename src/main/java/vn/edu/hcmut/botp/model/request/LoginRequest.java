package vn.edu.hcmut.botp.model.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import vn.edu.hcmut.botp.model.constant.UserRole;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class LoginRequest {
    private final String username;
    private final String password;
    private String email;
    private Set<UserRole> role;
}
