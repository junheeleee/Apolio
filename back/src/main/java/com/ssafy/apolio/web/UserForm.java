package com.ssafy.apolio.web;

import com.ssafy.apolio.domain.user.AuthProvider;
import com.ssafy.apolio.domain.user.Role;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserForm {
    private String username;

    private String password;

    private String email;

    private String picture;

    private String nickname;

    private Role role;

    private AuthProvider authProvider;
}
