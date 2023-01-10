package com.xun.playground.horr.story.controller;

import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.form.HorrStForm;
import com.xun.playground.horr.story.service.HorrStDetailService;
import com.xun.playground.horr.story.service.HorrStNewService;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * 무서운이야기 글쓰기
 */
@Controller
public class HorrStNewController {
    // 신규관련 서비스
    private final HorrStNewService horrorStoryWriteService;
    // 상세관련 서비스
    private final HorrStDetailService horrorStoryDetailService;

    public HorrStNewController(HorrStNewService horrorStoryWriteService, HorrStDetailService horrorStoryDetailService){
        this.horrorStoryWriteService = horrorStoryWriteService;
        this.horrorStoryDetailService = horrorStoryDetailService;
    }


    /**
     * 글쓰기 페이지로 이동
     * @return
     */
    @GetMapping("/horror/story/new")
    public String goHorrorStory(Model model, @RequestParam(required = false, value = "horrStNo") String horrStNo){
        // 수정인 경우, 값 조회
        if(!StringUtils.isEmpty(horrStNo)){
            Optional<HorrStDomain> story = horrorStoryDetailService.findHorrorStoryDetail(horrStNo);
            if(story != null) model.addAttribute("story", story.get());
        }

        return "horr/story/horrStNew";
    }

    /**
     * 글 저장 & 수정
     * @param form
     * @return
     */
    @PostMapping("/horror/story/new")
    public String saveStory(HorrStForm form){
        // todo 로그인 사용자 ID 가져오기
        form.setEnterBy("xunxou");
        horrorStoryWriteService.saveStory(form);

        return "horr/story/horrStList";
    }
}
