package vn.edu.hcmut.botp.model.constant;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRole {

    USER("USER"),
    PREMIUM("PREMIUM"),
    ADMIN("ADMIN");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    @JsonValue
    public String getRole() {
        return this.role;
    }
}
