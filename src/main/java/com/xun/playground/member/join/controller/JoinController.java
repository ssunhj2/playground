package com.xun.playground.member.join.controller;

import com.xun.playground.member.dto.MemberDTO;
import com.xun.playground.member.form.MemberForm;
import com.xun.playground.member.join.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * 회원가입 Controller
 */
@Controller
public class JoinController {
    private final JoinService joinService;

    @Autowired
    public JoinController(JoinService joinService){
        this.joinService = joinService;
    }

    @GetMapping("/join")
    public String goJoin(){
        return "member/join/join";
    }

    @PostMapping("/join")
    @ResponseBody
    public HashMap<String, String> saveMember(MemberForm form) throws NoSuchAlgorithmException {
        HashMap<String, String> resultMap = new HashMap<>();

        MemberDTO joinDto = new MemberDTO(form);
        String result = joinService.saveMember(joinDto);

        resultMap.put("result", result);

        return resultMap;
    }


    @PostMapping("/join/chkDupId")
    @ResponseBody
    public HashMap<String, String> chkDupId(@RequestParam("loginId") String loginId) {
        HashMap<String, String> resultMap = new HashMap<>();

        boolean isDup = joinService.chkDupId(loginId);
        resultMap.put("result", String.valueOf(isDup));

        return resultMap;
    }

}