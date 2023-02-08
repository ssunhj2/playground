package com.xun.playground.common.interceptor;

import com.xun.playground.common.config.dto.ConfigDTO;
import com.xun.playground.common.session.SessionManager;
import com.xun.playground.common.user.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * 권한관련 Interceptor
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final SessionManager sessionManager;

    // public List authPattrn = Arrays.asList("/**");
    public List authPattrn = Arrays.asList("/home/**", "/horror/**", "/account/**");
    public List unAuthPattrn = Arrays.asList("/", "/join", "/login", "/logout", "/css/**", "/.ico", "/error");

    public AuthInterceptor(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }


    /**
     * Controller로 가기 전 실행
     * 회원 권한체크 ()
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("============ AuthInterceptor preHandle ============");

        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute(ConfigDTO.SESSION_COOKIE_NAME);

        if(user == null) {
            // sessionManager에서 조회
            UserDTO smUser = sessionManager.getSession(request);

            if(smUser == null) {
                logger.info("====== UnAuthUSer: 인가되지 않은 사용자입니다. ==========");

                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html; charset=UTF-8");

                PrintWriter pw = response.getWriter();
                pw.println("<script> alert('로그인이 필요합니다.'); location.href='/login'; </script>");
                pw.flush();
                pw.close();

                return false;
            }
        }

        logger.info("====== [preHandel] AuthUser ==========");
        return true;

    }

}
