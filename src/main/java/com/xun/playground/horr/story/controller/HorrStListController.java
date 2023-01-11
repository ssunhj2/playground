package com.xun.playground.horr.story.controller;


import com.xun.playground.horr.story.dto.HorrStDTO;
import com.xun.playground.horr.story.service.HorrStListService;
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
public class HorrStListController {
    private final HorrStListService horrorStoryListService;

    @Autowired
    public HorrStListController(HorrStListService horrorStoryListService){
        this.horrorStoryListService = horrorStoryListService;
    }

    @GetMapping("/horror/story")
    public String findList(Model model) {
        List<HorrStDTO> storyList = horrorStoryListService.findAllList();
        model.addAttribute("storyList", storyList);

        return "horr/story/horrStList";
    }
}
