package com.xun.playground.join.controller;

import com.xun.playground.join.dto.JoinDTO;
import com.xun.playground.join.form.JoinForm;
import com.xun.playground.join.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        return "join/join";
    }

    @PostMapping("/join")
    @ResponseBody
    public HashMap<String, String> saveMember(JoinForm form) throws NoSuchAlgorithmException {
        HashMap<String, String> resultMap = new HashMap<>();

        JoinDTO joinDto = new JoinDTO(form);
        String result = joinService.saveMember(joinDto);

        resultMap.put("result", result);

        return resultMap;
    }

}
