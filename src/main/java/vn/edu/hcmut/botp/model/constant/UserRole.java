package vn.edu.hcmut.botp.model.constant;

import lombok.Getter;

@Getter
public enum UserRole {

    USER("USER_ROLE"),
    DEVELOPER("DEVELOPER_ROLE"),
    ADMIN("ADMIN_ROLE");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }


}
