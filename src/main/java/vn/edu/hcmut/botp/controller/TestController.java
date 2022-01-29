package vn.edu.hcmut.botp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hcmut.botp.model.response.BasicResponse;
import vn.edu.hcmut.botp.service.AuthService;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    AuthService authService;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/premium")
    @PreAuthorize("hasRole('PREMIUM')")
    public String premiumAccess() {
        return "Premium Content.";
    }


    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }





}