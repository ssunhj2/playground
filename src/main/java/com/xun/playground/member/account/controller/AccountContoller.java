package com.xun.playground.member.account.controller;

import com.xun.playground.member.account.service.AccountService;
import com.xun.playground.common.session.SessionManager;
import com.xun.playground.common.user.dto.UserDTO;
import com.xun.playground.member.dto.MemberDTO;
import com.xun.playground.member.form.MemberForm;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 회원계정 Contoller
 */
@Controller
public class AccountContoller {
    private final AccountService accountService;
    private final SessionManager sessionManager;
    @Autowired
    public AccountContoller(AccountService accountService, SessionManager sessionManager){
        this.accountService = accountService;
        this.sessionManager = sessionManager;
    }

    /*@GetMapping("/account")
    public String goUnAuthAccount() {
        return "account/unAuthAccount";
    }


    @PostMapping("/account")
    public String checkAuthUser(HttpServletRequest request, @RequestParam("password") String password, RedirectAttributes re){
        UserDTO userDto = sessionManager.getSession(request);

        if(userDto == null) {
            re.addAttribute("msg", "500"); // 로그인이 필요합니다.
            return "redirect:/account/unAuthAccount";
        }

        String memberNo = userDto.getMemberNo();
        boolean isAuth = accountService.checkAuthUser(memberNo, password);

        // url로 이동하는것을 막기위해 성공 시 여기서 바로 이동
        // /account/authAccount mapping을 만들지 않는다.
        if(isAuth) return "account/authAccount";

        re.addAttribute("msg", "400"); // 비밀번호가 맞지 않습니다.
        return "redirect:/account/unAuthAccount";
    }*/

    @GetMapping("/account")
    public String goAuthAccount() {
        return "member/account/authAccount";
    }


    // 회원정보 조회
    @PostMapping("/account/authAccount")
    @ResponseBody
    public HashMap<String, Object> findUser(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();

        UserDTO userDto = sessionManager.getSession(request);

        if(userDto != null) {
            String memberNo = userDto.getMemberNo();
            MemberDTO member = accountService.findUser(memberNo);

            resultMap.put("member", member);
        }

        return resultMap;
    }

    // 회원정보 수정
    @PostMapping("/account/modifyAccount")
    @ResponseBody
    public HashMap<String, Object> modifyAccount(HttpServletRequest request, MemberForm memberForm){
        HashMap<String, Object> resultMap = new HashMap<>();

        UserDTO userDto = sessionManager.getSession(request);

        if(userDto == null) {
            resultMap.put("result", "fail"); // 유효하지 않은 사용자입니다.
            return resultMap;
        }

        String memberNo = userDto.getMemberNo();
        MemberDTO memberDto = new MemberDTO(memberForm);

        boolean result = accountService.modifyAccount(memberNo, memberDto);

        resultMap.put("result", result);
        return resultMap;
    }

    /**
     * 회원탈퇴
     * @param request
     * @return
     */
    @PostMapping("/account/leaveAccount")
    @ResponseBody
    public HashMap<String, Object> leaveAccount(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();

        UserDTO userDto = sessionManager.getSession(request);

        if(userDto == null || StringUtils.isEmpty(userDto.getMemberNo())) {
            resultMap.put("result", "fail"); // 유효하지 않은 사용자입니다.
            return resultMap;
        }

        boolean result = accountService.leaveAccount(userDto.getMemberNo());
        resultMap.put("result", result);
        
        // 세션 삭제
        sessionManager.expire(request);

        return resultMap;
    }


    @GetMapping("/redirectMsg")
    @ResponseBody
    private String redirectMsg(@RequestParam("message") String message){
        return "";
    }


}
