package vn.edu.hcmut.botp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hcmut.botp.model.JWTTokenProvider;
import vn.edu.hcmut.botp.model.MyUserDetails;
import vn.edu.hcmut.botp.model.request.LoginRequest;
import vn.edu.hcmut.botp.model.response.LoginResponse;

@RestController
@RequiredArgsConstructor
public class FrontController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenProvider tokenProvider;

    @PostMapping("/login")
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((MyUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }


}
