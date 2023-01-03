package com.xun.playground.horror.story.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 무서운이야기 상세페이지
 */
@Controller
public class HorrorStoryDetailController {
    @GetMapping("/horrorStoryDetail")
    public String welcome() {
        return "horror/story/horrorStoryDetail";
    }
}
