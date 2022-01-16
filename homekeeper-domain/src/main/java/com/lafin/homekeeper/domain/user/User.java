package com.lafin.homekeeper.domain.user;

import com.lafin.homekeeper.global.type.UserStatus;
import com.lafin.homekeeper.global.type.UserType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
public class User {

    private Long id;

    private UserStatus status;

    private String email;

    private String name;

    private String password;

    private UserType userType;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    public void active() {
        this.status = UserStatus.ACTIVE;
        this.updatedAt = LocalDateTime.now();
    }

    public void inActive() {
        this.status = UserStatus.INACTIVE;
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
                .status(UserStatus.ACTIVE)
                .email(email)
                .name(name)
                .password(password)
                .userType(UserType.USER)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User createAdmin(String email, String name, String password) {
        return User.builder()
                .status(UserStatus.ACTIVE)
                .email(email)
                .name(name)
                .password(password)
                .userType(UserType.ADMIN)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
