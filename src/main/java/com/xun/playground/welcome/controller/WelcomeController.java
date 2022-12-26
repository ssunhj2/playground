package com.xun.playground.welcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * welcome 페이지
 * 사용자들이 첫 접속시 해당 페이지를 보게된다.
 * 로그인, 회원가입 구성할 페이지
 * 추후 사용자권한 추가시 해당페이지에서는 권한체크하지 않는다.
 */
@Controller
public class WelcomeController {
    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }
}
