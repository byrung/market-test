package com.example.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/menu_Seasonal")
    public String menuSeasonal() {
        return "menu_Seasonal";
    }

    @GetMapping("/menu_ProdMap")
    public String menuProdMap() {
        return "menu_ProdMap";
    }

    @GetMapping("/menu_Intro")
    public String menuIntro() {
        return "menu_Intro";
    }

    @GetMapping("/regist")
    public String regist() {
        return "regist";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/memberInfo")
    public String memberInfo() {
        return "memberInfo";
    }

    @GetMapping("/basket")
    public String basket() {
        return "basket";
    }

    @GetMapping("/PC_LI_01")
    public String pcLi01() {
        return "PC_LI_01";
    }

    @GetMapping("/PC_LI_02")
    public String pcLi02() {
        return "PC_LI_02";
    }

    @GetMapping("/PC_LI_03")
    public String pcLi03() {
        return "PC_LI_03";
    }

    @GetMapping("/PC_DE_01")
    public String pcDe01() {
        return "PC_DE_01";
    }
}
