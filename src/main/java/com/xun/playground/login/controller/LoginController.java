package com.xun.playground.login.controller;

import com.xun.playground.common.config.dto.ConfigDTO;
import com.xun.playground.common.session.SessionManager;
import com.xun.playground.common.user.dto.UserDTO;
import com.xun.playground.common.util.CommonUtils;
import com.xun.playground.login.dto.LoginDTO;
import com.xun.playground.login.form.LoginForm;
import com.xun.playground.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * 로그인 Controller
 */
@Controller
public class LoginController {
    private final LoginService loginService;
    private final SessionManager sessionManager;

    @Autowired
    public LoginController(LoginService loginService, SessionManager sessionManager){
        this.loginService = loginService;
        this.sessionManager = sessionManager;
    }

    /**
     * 로그인페이지 조회
     * @return
     */
    @GetMapping("/login")
    public String goLogin(HttpServletRequest request){
        UserDTO user = CommonUtils.getUser(request);

        if(user == null) return "login/login";

        return "/home";
    }


    /**
     * 로그인 처리
     * @param loginForm
     * @param response
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public HashMap<String, String> login(LoginForm loginForm, HttpServletRequest request, HttpServletResponse response){
        HashMap<String, String> resultMap = new HashMap<>();

        LoginDTO loginDTO = new LoginDTO(loginForm);
        UserDTO user = loginService.login(loginDTO);

        // 회원이 아닙니다.
        if(user == null) {
            resultMap.put("result", "fail");
            return resultMap;
        }

        // 로그인 성공
        // 세션관리자를 통해 세션을 생성한다.
        sessionManager.createSession(user, response);
        resultMap.put("result", "success");

        // servlet을 통해 HttpSession 생성
        HttpSession session = request.getSession();
        session.setAttribute(ConfigDTO.SESSION_COOKIE_NAME, user);
        
        return resultMap; // result 가 성공이면 home으로
    }


    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sessionManager.expire(request);

        HttpSession session = request.getSession();
        if(session != null){
            session.invalidate(); // 세션 무효화
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter pw = response.getWriter();
        pw.println("<script> alert('로그아웃 되었습니다.'); location.href='/'; </script>");
        pw.flush();
        pw.close();

    }

}
