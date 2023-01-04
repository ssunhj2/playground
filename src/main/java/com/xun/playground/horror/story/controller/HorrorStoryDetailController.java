package com.xun.playground.horror.story.controller;

import com.xun.playground.horror.story.domain.HorrorStoryDomain;
import com.xun.playground.horror.story.service.HorrorStoryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 무서운이야기 상세페이지 controller
 */
@Controller
public class HorrorStoryDetailController {
    private final HorrorStoryDetailService horrorStoryDetailService;

    @Autowired
    public HorrorStoryDetailController(HorrorStoryDetailService horrorStoryDetailService){
        this.horrorStoryDetailService = horrorStoryDetailService;
    }

    @GetMapping("/horror/story/detail")
    public String welcome(Model model, @RequestParam("horrStNo") String horrStNo) {
        // 상세페이지 데이터 조회
        HorrorStoryDomain story = horrorStoryDetailService.findHorrorStoryDetail(horrStNo);
        model.addAttribute("story", story);

        return "horror/story/horrorStoryDetail";
    }
}
