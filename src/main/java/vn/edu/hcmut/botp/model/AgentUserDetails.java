package vn.edu.hcmut.botp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vn.edu.hcmut.botp.model.constant.UserRole;
import vn.edu.hcmut.botp.model.entity.BOTPUser;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class AgentUserDetails implements UserDetails {
    private final BOTPUser user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(UserRole.USER.getRole()));

    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    public Set<UserRole> getRoles() {
        return user.getRoles();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
