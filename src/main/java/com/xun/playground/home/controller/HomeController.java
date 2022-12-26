package com.xun.playground.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * main home 페이지
 * welcome 페이지에서 로그인 후 보여지는 페이지
 * 권한체크 대상이 되는 페이지
 */
@Controller
public class HomeController {
    @GetMapping("/home")
    public String welcome() {
        return "home";
    }
}
