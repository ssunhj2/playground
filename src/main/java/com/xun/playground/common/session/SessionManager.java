package com.xun.playground.common.session;

import com.xun.playground.common.user.dto.UserDTO;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 세션관리
 */
@Component
public class SessionManager {
    private static final String SESSION_COOKIE_NAME = "mySessionId";
    // 동시요청에 안전한 ConcurrentHashMap 사용
    private Map<String, UserDTO> sessionTable = new ConcurrentHashMap<>();

    /**
     * 세션 생성
     * @param user
     * @param response
     */
    public void createSession(UserDTO user, HttpServletResponse response){
        // 세션 ID 생성
        String sessionId = UUID.randomUUID().toString();
        sessionTable.put(sessionId, user); // 값을 session에 저장

        // 쿠키생성
        Cookie sessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(sessionCookie);
    }

    /**
     * 세션 조회
     * @param request
     * @return
     */
    public UserDTO getSession(HttpServletRequest request){
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);

        if(sessionCookie == null){
            return null;
        }

        return sessionTable.get(sessionCookie.getValue());
    }

    /**
     * 세션 만료
     * @param request
     */
    public void expire(HttpServletRequest request){
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if(sessionCookie != null){
            sessionTable.remove(sessionCookie.getValue());
        }
    }

    /**
     * 쿠키를 찾아 반환한다.
     * @param request
     * @param cookieName
     * @return
     */
    private Cookie findCookie(HttpServletRequest request, String cookieName){
        return Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals(cookieName))
                .findAny()
                .orElse(null);
    }
}
