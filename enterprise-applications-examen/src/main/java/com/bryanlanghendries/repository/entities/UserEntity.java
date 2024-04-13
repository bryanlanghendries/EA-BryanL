package com.bryanlanghendries.repository.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Size;

@Entity
@Table(name="user")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Size(max = 50)
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Size(min = 3, max = 255)
    @Column(name = "email")
    private String email;

    @NonNull
    @Size(min = 6, max = 128)
    @Column(name = "password")
    private String password;

    @Column(name = "is_admin", columnDefinition = "boolean default false")
    private boolean isAdmin;

    public UserEntity(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password, Boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}
