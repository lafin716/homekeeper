package com.lafin.homekeeper.domain.user;

import com.lafin.homekeeper.global.type.UserType;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private Long id;

    private String email;

    private String name;

    private String password;

    private UserType userType;
}
