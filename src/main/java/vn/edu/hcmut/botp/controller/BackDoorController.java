package vn.edu.hcmut.botp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hcmut.botp.model.response.BasicResponse;
import vn.edu.hcmut.botp.service.AuthService;

@RestController
@RequestMapping("/api/backdoor")
public class BackDoorController {
    @Autowired
    AuthService authService;

    @DeleteMapping("/clean")
    public BasicResponse cleanUserDB(){
        return authService.deleteUserDatabase() ? new BasicResponse(true) : new BasicResponse(false, "");
    }
}
