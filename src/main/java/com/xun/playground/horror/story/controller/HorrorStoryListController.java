package com.xun.playground.horror.story.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 무서운이야기 목록페이지
 * 권한체크 대상이 되는 페이지
 */
@Controller
public class HorrorStoryListController {
    @GetMapping("/horrorStory")
    public String welcome() {
        return "horror/story/horrorStoryList";
    }
}
