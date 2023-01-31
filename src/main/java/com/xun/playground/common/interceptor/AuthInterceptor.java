package com.xun.playground.common.interceptor;

import com.xun.playground.common.session.SessionManager;
import com.xun.playground.common.user.dto.UserDTO;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 권한관련 Interceptor
 */
public class AuthInterceptor implements HandlerInterceptor {
    private final SessionManager sessionManager;

    @Autowired
    public AuthInterceptor(SessionManager sessionManager){
        this.sessionManager = sessionManager;
    }

    /**
     * 회원 권한체크 (Controller 가기 전 실행)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        UserDTO userDto = sessionManager.getSession(request);

        if(userDto != null && StringUtils.isEmpty(userDto.getMemberNo())) return true;

        // 유효하지 않은 사용자 메세지
        ModelAndView modelAndView = new ModelAndView("redirect:/forward");
        modelAndView.addObject("msg", "세션이 만료되어 로그아웃 되었습니다. 다시 로그인 해주세요.");
        modelAndView.addObject("returnPath", "/");
        throw new ModelAndViewDefiningException(modelAndView);

    }

}
