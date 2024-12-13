package com.example.market.controller;

import com.example.market.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = authService.authenticateUser(username, password);
        if (isAuthenticated) {
            // 세션에 사용자 정보 추가 (Spring Security Context 활용 가능)
            return ResponseEntity.ok().body("로그인 성공");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패: 잘못된 자격 증명");
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        // 로그아웃 처리 (세션 삭제 또는 Spring Security Context에서 Authentication 제거)
        return ResponseEntity.ok().body("로그아웃 성공");
    }
}
