package com.example.market.controller;

import com.example.market.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "로그인 실패: 잘못된 자격 증명입니다.");
        }
        return "login"; // login.html 반환
    }

    @PostMapping("/register")
    public String registerPage() {
        return "register"; // register.html 반환
    }
}
