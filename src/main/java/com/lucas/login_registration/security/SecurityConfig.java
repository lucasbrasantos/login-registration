package com.lucas.login_registration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin(httpForm -> {
                    httpForm.loginPage("/login").permitAll();
                })
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/req/signup").permitAll();
                    auth.anyRequest().authenticated();
                })
                .build();

    }
}
