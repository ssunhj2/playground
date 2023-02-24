package com.xun.playground.home.controller;

import com.xun.playground.common.config.dto.ConfigDTO;
import com.xun.playground.common.user.dto.UserDTO;
import com.xun.playground.common.util.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * main home 페이지
 * welcome 페이지에서 로그인 후 보여지는 페이지
 * 권한체크 대상이 되는 페이지
 */
@Controller
public class HomeController {
    @GetMapping("/home")
    public String welcome(HttpServletRequest request, Model model) {
        UserDTO user = CommonUtils.getUser(request);
        if(user == null) return "/login";
        
        return "home";
    }

    // 로그인 사용자 이름조회
    @PostMapping("/top/name")
    @ResponseBody
    public HashMap<String, String> getUserName(HttpServletRequest request){
        HashMap<String, String> resultMap = new HashMap<>();

        UserDTO user = CommonUtils.getUser(request);
        if(user != null) resultMap.put("userName", user.getName());

        return resultMap;
    }
}
