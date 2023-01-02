package com.xun.playground.horror.story.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * hrror 컨텐츠 홈
 * 권한체크 대상이 되는 페이지
 */
@Controller
public class HorrorHomeController {
    @GetMapping("/horror")
    public String welcome() {
        return "horror/horrorHome";
    }
}
