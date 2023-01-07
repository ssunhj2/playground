package com.xun.playground.horr.story.controller;

import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.form.HorrStForm;
import com.xun.playground.horr.story.service.HorrStDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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

    // 상세페이지 조회
    @GetMapping("/horror/story/detail")
    public String findDetail(Model model, @RequestParam("horrStNo") String horrStNo) {

        if(!"".equals(horrStNo) && horrStNo != null){
            // 상세페이지 데이터 조회
            Optional<HorrStDomain> story = horrorStoryDetailService.findHorrorStoryDetail(horrStNo);
            // null인 경우, exception이 나지 않도록 생성자를
            HorrStDomain result = story.orElseGet(HorrStDomain::new);

            model.addAttribute("story", result);
        }

        return "horr/story/horrStDetail";
    }

    // story 삭제
    @PostMapping("/horror/story/delete")
    public void deleteStory(@RequestParam("horrStNo") String horrStNo){
        horrorStoryDetailService.deleteStory(horrStNo);
    }
}
