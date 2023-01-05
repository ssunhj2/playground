package com.xun.playground.horr.story.controller;

import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.service.HorrStDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


/**
 * 무서운이야기 상세페이지 controller
 */
@Controller
public class HorrStDetailController {
    private final HorrStDetailService horrorStoryDetailService;

    @Autowired
    public HorrStDetailController(HorrStDetailService horrorStoryDetailService){
        this.horrorStoryDetailService = horrorStoryDetailService;
    }

    @GetMapping("/horror/story/detail")
    public String findDetail(Model model, @RequestParam("horrStNo") String horrStNo) {
        // 상세페이지 데이터 조회
        Optional<HorrStDomain> story = horrorStoryDetailService.findHorrorStoryDetail(horrStNo);
        model.addAttribute("story", story);

        return "horr/story/horrStDetail";
    }
}
