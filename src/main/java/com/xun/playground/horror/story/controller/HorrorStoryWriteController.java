package com.xun.playground.horror.story.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 무서운이야기 글쓰기
 */
@Controller
public class HorrorStoryWriteController {

    @GetMapping("/horror/story/new")
    public String newHorrorStory(){
        return "horror/story/horrorStoryWrite";
    }
}
