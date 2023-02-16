package com.xun.playground.home.controller;

import com.xun.playground.common.config.dto.ConfigDTO;
import com.xun.playground.common.user.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * main home 페이지
 * welcome 페이지에서 로그인 후 보여지는 페이지
 * 권한체크 대상이 되는 페이지
 */
@Controller
public class HomeController {
    @GetMapping("/home")
    public String welcome(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute(ConfigDTO.SESSION_COOKIE_NAME);

        if(user == null) return "/login";

        model.addAttribute("userName", user.getName());

        return "home";
    }
}
