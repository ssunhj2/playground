package com.xun.playground.horror.home.controller;

import com.xun.playground.horror.story.domain.HorrorStoryDomain;
import com.xun.playground.horror.story.service.HorrorStoryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * hrror 컨텐츠 홈
 * 권한체크 대상이 되는 페이지
 */
@Controller
public class HorrorHomeController {
    private final HorrorStoryListService horrorStoryListService;
    @Autowired
    public HorrorHomeController(HorrorStoryListService horrorStoryListService){
        this.horrorStoryListService = horrorStoryListService;
    }

    @GetMapping("/horror")
    public String goHorrorHome(Model model) {
        // 무서운이야기 게시판 목록 조회
        List<HorrorStoryDomain> storyList = horrorStoryListService.findHorrorStoryList();
        model.addAttribute("storyList", storyList);

        return "horror/horrorHome";
    }
}
