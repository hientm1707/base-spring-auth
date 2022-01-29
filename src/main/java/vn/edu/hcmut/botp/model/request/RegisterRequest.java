package vn.edu.hcmut.botp.model.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import vn.edu.hcmut.botp.model.constant.UserRole;

import javax.validation.constraints.Email;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class RegisterRequest {
    @NonNull
    private String username;
    @NonNull
    private String password;

    @Email
    private String email;

    @NonNull
    private Set<UserRole> roles;
}
