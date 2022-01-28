package vn.edu.hcmut.botp.service;

import org.springframework.web.bind.annotation.RequestBody;
import vn.edu.hcmut.botp.model.request.RegisterRequest;
import vn.edu.hcmut.botp.model.response.BasicResponse;

public interface UserService {
    BasicResponse registerNewAccount(@RequestBody RegisterRequest registerRequest);
    boolean verifyPassword(String rawPassword, String realPassword);
}
