package com.lucas.login_registration.model;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String email;
    private String password;

    public User(UserRequestDTO data) {
        this.username = data.username();
        this.email = data.email();
        this.password = data.password();
    }
}
