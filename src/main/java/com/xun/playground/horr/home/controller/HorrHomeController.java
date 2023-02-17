package com.xun.playground.horr.home.controller;

import com.xun.playground.horr.story.dto.HorrStDTO;
import com.xun.playground.horr.story.service.HorrStListService;
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
public class HorrHomeController {
    private final HorrStListService horrorStoryListService;
    @Autowired
    public HorrHomeController(HorrStListService horrorStoryListService){
        this.horrorStoryListService = horrorStoryListService;
    }

    @GetMapping("/horror")
    public String goHorrorHome(Model model) {
        // 무서운이야기 게시판 목록 조회
        List<HorrStDTO> storyList = horrorStoryListService.findTopList();
        model.addAttribute("storyList", storyList);

        return "horr/horrorHome";
    }
}
