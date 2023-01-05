package com.xun.playground.horr.story.controller;

import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.form.HorrStForm;
import com.xun.playground.horr.story.service.HorrStNewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 무서운이야기 글쓰기
 */
@Controller
public class HorrStNewController {

    private final HorrStNewService horrorStoryWriteService;


    public HorrStNewController(HorrStNewService horrorStoryWriteService){
        this.horrorStoryWriteService = horrorStoryWriteService;
    }


    /**
     * 글쓰기 페이지로 이동
     * @return
     */
    @GetMapping("/horror/story/new")
    public String goHorrorStory(){
        return "horr/story/horrStNew";
    }

    
    @PostMapping("/horror/story/new")
    public String createStory(HorrStForm form){
        HorrStDomain story = new HorrStDomain();
        horrorStoryWriteService.createStory(form);

        return "redirect:/";
    }
}
