package com.project.easyEvent.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.easyEvent.user.model.entity.Users;

public class PasswordEncoderUtil {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void encode(Users user) {
        String encodedPassword = encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

    private String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

}
