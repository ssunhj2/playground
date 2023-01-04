package com.xun.playground.horror.story.controller;

import com.xun.playground.horror.story.domain.HorrorStoryDomain;
import com.xun.playground.horror.story.service.HorrorStoryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 무서운이야기 목록페이지 controller
 * 권한체크 대상이 되는 페이지
 */
@Controller
public class HorrorStoryListController {
    private final HorrorStoryListService horrorStoryListService;

    @Autowired
    public HorrorStoryListController(HorrorStoryListService horrorStoryListService){
        this.horrorStoryListService = horrorStoryListService;
    }

    @GetMapping("/horror/story")
    public String findHorrorStoryList(Model model) {
        List<HorrorStoryDomain> storyList = horrorStoryListService.findHorrorStoryList();
        model.addAttribute("storyList", storyList);

        return "horror/story/horrorStoryList";
    }
}
