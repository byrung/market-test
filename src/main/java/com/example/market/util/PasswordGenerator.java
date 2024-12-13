package com.example.market.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "@Polytech2301110323"; // 원본 비밀번호
        String encodedPasswordFromDB = "$2a$10$bZwn.ly/ek.rkZwAp5AsVO.9PXJrXDNGg6WPZWVYPZs5rW1Z0/A/u"; // DB에 저장된 암호화된 비밀번호

        boolean isPasswordMatch = encoder.matches(rawPassword, encodedPasswordFromDB);
        System.out.println("비밀번호 일치 여부: " + isPasswordMatch);
    }
}
