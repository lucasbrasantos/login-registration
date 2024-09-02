package com.lucas.login_registration.model;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.lucas.login_registration.model.User;

import java.util.Optional;

import static com.lucas.login_registration.model.User.*;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        var userObject = user.get();

        return org.springframework.security.core.userdetails.User.builder()
                .username(userObject.getUsername())
                .password(userObject.getPassword())
                .build();
    }

}
