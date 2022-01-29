package vn.edu.hcmut.botp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.edu.hcmut.botp.model.AgentUserDetails;
import vn.edu.hcmut.botp.repository.UserRepository;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = Optional.of(userRepository.findByUsername(username)).orElseThrow(
                () ->new UsernameNotFoundException("Username not found")
        );
        return new AgentUserDetails(user);
    }

}
