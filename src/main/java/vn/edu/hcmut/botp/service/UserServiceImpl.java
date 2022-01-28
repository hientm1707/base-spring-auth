package vn.edu.hcmut.botp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.hcmut.botp.model.constant.AgentConstant;
import vn.edu.hcmut.botp.model.entity.BOTPUser;
import vn.edu.hcmut.botp.model.request.RegisterRequest;
import vn.edu.hcmut.botp.model.response.BasicResponse;
import vn.edu.hcmut.botp.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    @Override
    public BasicResponse registerNewAccount(RegisterRequest registerRequest) {

        var user = Optional.ofNullable(userRepository.findByUsername(registerRequest.getUsername()));
        if (user.isPresent()){
            return new BasicResponse(
                    false,
                    AgentConstant.USER_EXISTED);
        }

        userRepository.save(new BOTPUser(registerRequest.getUsername(), bCryptPasswordEncoder.encode(registerRequest.getPassword())));
        return new BasicResponse(true);
    }

    @Override
    public boolean verifyPassword(String rawPassword, String reqPassword) {
       return bCryptPasswordEncoder.matches(rawPassword, reqPassword);
    }
}
