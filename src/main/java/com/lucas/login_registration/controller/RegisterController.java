package com.lucas.login_registration.controller;


import com.lucas.login_registration.model.User;
import com.lucas.login_registration.model.UserRepository;
import com.lucas.login_registration.model.UserRequestDTO;
import com.lucas.login_registration.model.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/signup", consumes = "application/json")
    public UserResponseDTO create(@RequestBody UserRequestDTO userRequestDTO) {
        User user = new User(userRequestDTO);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return new UserResponseDTO(user);
    }

}
