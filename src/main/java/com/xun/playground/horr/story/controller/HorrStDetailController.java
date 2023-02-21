package com.xun.playground.horr.story.controller;


import com.xun.playground.common.config.dto.ConfigDTO;
import com.xun.playground.common.file.dto.FileDTO;
import com.xun.playground.common.file.service.FileLocalService;
import com.xun.playground.common.user.dto.UserDTO;
import com.xun.playground.common.util.CommonUtils;
import com.xun.playground.horr.story.dto.HorrStDTO;
import com.xun.playground.horr.story.service.HorrStDetailService;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


/**
 * 무서운이야기 상세페이지 controller
 */
@Controller
public class HorrStDetailController {
    private final HorrStDetailService horrorStoryDetailService;
    // 파일 서비스
    private final FileLocalService fileService;

    @Autowired
    public HorrStDetailController(HorrStDetailService horrorStoryDetailService, FileLocalService fileService){
        this.horrorStoryDetailService = horrorStoryDetailService;
        this.fileService = fileService;
    }

    // 상세페이지 조회
    @GetMapping("/horror/story/detail")
    public String findDetail(HttpServletRequest request, Model model, @RequestParam("horrStNo") String horrStNo) {

        if(!StringUtils.isEmpty(horrStNo)){
            UserDTO user = CommonUtils.getUser(request);

                    // 상세페이지 데이터 조회
            HorrStDTO story = horrorStoryDetailService.findDetail(horrStNo);
            // null인 경우, exception이 나지 않도록 생성자를 반환
            //HorrStDTO result = story.orElseGet(HorrStDTO::new);
            model.addAttribute("story", story);

            String memberNo = story.getMemberNo();
            String reqMemberNo = user.getMemberNo();
            String isWriter = (!"".equals(memberNo) && memberNo.equals(reqMemberNo)) ? "true" : "false";
            model.addAttribute("isWriter", isWriter);

            // todo 추후 local인지, cloud인지 판별해서 download 호출
            // 첨부파일 조회
            List<FileDTO> files = fileService.getAttaches("HORR_ST", story.getHorrStNo());
            model.addAttribute("files", files);
        }

        return "horr/story/horrStDetail";
    }

    // story 삭제
    @PostMapping("/horror/story/delete")
    @ResponseBody
    public void deleteStory(HttpServletRequest request, @RequestParam("horrStNo") String horrStNo){
        UserDTO user = CommonUtils.getUser(request);
        horrorStoryDetailService.deleteStory(horrStNo, user.getMemberNo());
    }

}
