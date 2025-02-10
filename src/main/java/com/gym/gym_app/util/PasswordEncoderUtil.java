package com.gym.gym_app.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {

    public static String encodePassword(String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(rawPassword);
    }

    public static void main(String[] args) {
        String rawPassword = "nouvelpass";
        String encodedPassword = encodePassword(rawPassword);
        System.out.println(encodedPassword);
    }
}
