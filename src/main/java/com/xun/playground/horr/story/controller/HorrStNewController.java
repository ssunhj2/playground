package com.xun.playground.horr.story.controller;

import com.xun.playground.common.file.dto.FileDTO;
import com.xun.playground.common.file.service.FileLocalService;
import com.xun.playground.common.user.dto.UserDTO;
import com.xun.playground.common.util.CommonUtils;
import com.xun.playground.horr.story.dto.HorrStDTO;
import com.xun.playground.horr.story.form.HorrStForm;
import com.xun.playground.horr.story.service.HorrStDetailService;
import com.xun.playground.horr.story.service.HorrStNewService;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;


/**
 * 무서운이야기 글쓰기
 */
@Controller
public class HorrStNewController {
    // 신규 서비스
    private final HorrStNewService horrorStoryWriteService;
    // 상세 서비스
    private final HorrStDetailService horrorStoryDetailService;

    // 파일 서비스
    private final FileLocalService fileService;

    public HorrStNewController(HorrStNewService horrorStoryWriteService, HorrStDetailService horrorStoryDetailService, FileLocalService fileService){
        this.horrorStoryWriteService = horrorStoryWriteService;
        this.horrorStoryDetailService = horrorStoryDetailService;
        this.fileService = fileService;
    }


    /**
     * 글쓰기 페이지로 이동
     * @return
     */
    @GetMapping("/horror/story/new")
    public String goHorrorStory(Model model, @RequestParam(required = false, value = "horrStNo") String horrStNo){

        model.addAttribute("horrStNo", horrStNo);

        return "horr/story/horrStNew";
    }

    @PostMapping("/horror/story/story")
    @ResponseBody
    public HashMap<String, Object> findStory(@RequestParam(required = false, value = "horrStNo") String horrStNo){
        HashMap<String, Object> resultMap = new HashMap<>();

        // 수정인 경우, 값 조회
        if(!StringUtils.isEmpty(horrStNo)){
            HorrStDTO story = horrorStoryDetailService.findDetail(horrStNo);
            resultMap.put("result", story);
        }

        return resultMap;
    }

    /**
     * 글 저장 & 수정
     * @param form
     * @return
     */
    @PostMapping("/horror/story/new")
    public String saveStory(HttpServletRequest request, HorrStForm form, @RequestParam(required = false, value = "file") List<MultipartFile> files){
        UserDTO user = CommonUtils.getUser(request);
        if(user != null){
            String enterBy = user.getMemberNo();

            form.setEnterBy(enterBy);
            // story 저장
            HorrStDTO story = new HorrStDTO(form);
            HorrStDTO result = horrorStoryWriteService.saveStory(story);

            // file저장
            if(!CollectionUtils.isEmpty(files)){
                FileDTO fileDto = new FileDTO();
                fileDto.setAttachType("HORR_ST");
                fileDto.setAttachNo(result.getHorrStNo());
                fileDto.setEnterBy(enterBy);
                fileService.upload(fileDto, files);
            }
        }

        return "horr/story/horrStList";
    }
}
