package com.example.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {

    @GetMapping("/access-denied")
    public String accessDenied() {
        // 권한 없음 페이지를 보여준 뒤 로그인 페이지로 리다이렉트
        return "redirect:/login?error=access-denied";
    }
}
