package com.lucas.login_registration.controller;

import com.lucas.login_registration.model.User;
import com.lucas.login_registration.model.UserRepository;
import com.lucas.login_registration.model.UserRequestDTO;
import com.lucas.login_registration.model.UserResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ContentController {

    private UserRepository userRepository;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }
}
