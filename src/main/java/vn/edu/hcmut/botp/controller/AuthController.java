package vn.edu.hcmut.botp.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hcmut.botp.model.AgentUserDetails;
import vn.edu.hcmut.botp.model.request.LoginRequest;
import vn.edu.hcmut.botp.model.request.RegisterRequest;
import vn.edu.hcmut.botp.model.response.BasicResponse;
import vn.edu.hcmut.botp.model.response.LoginResponse;
import vn.edu.hcmut.botp.service.UserService;
import vn.edu.hcmut.botp.utils.JWTTokenProvider;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JWTTokenProvider tokenProvider;

    private final UserService userService;

    @ResponseBody
    @PostMapping("/login")
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest) {
        log.info("Logging in");
        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        var userDetails = (AgentUserDetails) authentication.getPrincipal();
        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken(userDetails);
        return LoginResponse.of(
                jwt,
                userDetails.getUsername(),
                userDetails.getPassword(),
                userDetails.getRoles()
        );
    }

    @PostMapping("/register")
    public BasicResponse registerUser(@RequestBody RegisterRequest registerRequest) {
        log.info("User is requesting to register a new account: {}", registerRequest.toString());
        return userService.registerNewAccount(registerRequest);
    }




}
