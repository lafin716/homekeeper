package com.lafin.homekeeper.domain.user;

import com.lafin.homekeeper.global.type.Status;
import com.lafin.homekeeper.global.type.UserType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@ToString
public class User {

    private Long id;

    private Status status;

    private String email;

    private String name;

    private String password;

    private UserType userType;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    public void active() {
        this.status = Status.ACTIVE;
        this.updatedAt = LocalDateTime.now();
    }

    public void inActive() {
        this.status = Status.INACTIVE;
        this.updatedAt = LocalDateTime.now();
    }

    public void update(String name) {
        this.name = name;
        this.updatedAt = LocalDateTime.now();
    }

    public void resetPassword(String password) {
        this.password = password;
        this.updatedAt = LocalDateTime.now();
    }

    public static User createUser(String email, String name, String password) {
        return User.builder()
                .status(Status.ACTIVE)
                .email(email)
                .name(name)
                .password(password)
                .userType(UserType.USER)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User createAdmin(String email, String name, String password) {
        return User.builder()
                .status(Status.ACTIVE)
                .email(email)
                .name(name)
                .password(password)
                .userType(UserType.ADMIN)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
