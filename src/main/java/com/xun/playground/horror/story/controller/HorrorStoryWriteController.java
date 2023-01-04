package com.xun.playground.horror.story.controller;

import com.xun.playground.horror.story.domain.HorrorStoryDomain;
import com.xun.playground.horror.story.form.HorrorStoryForm;
import com.xun.playground.horror.story.service.HorrorStoryWriteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 무서운이야기 글쓰기
 */
@Controller
public class HorrorStoryWriteController {

    private final HorrorStoryWriteService horrorStoryWriteService;


    public HorrorStoryWriteController(HorrorStoryWriteService horrorStoryWriteService){
        this.horrorStoryWriteService = horrorStoryWriteService;
    }


    /**
     * 글쓰기 페이지로 이동
     * @return
     */
    @GetMapping("/horror/story/new")
    public String goHorrorStory(){
        return "horror/story/horrorStoryWrite";
    }

    
    @PostMapping("/horror/story/new")
    public String createStory(HorrorStoryForm form){
        HorrorStoryDomain story = new HorrorStoryDomain();
        horrorStoryWriteService.createStory(form);

        return "redirect:/";
    }
}
