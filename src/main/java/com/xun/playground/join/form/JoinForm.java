package com.xun.playground.join.form;

import lombok.Getter;
import lombok.Setter;

/**
 * 회원가입
 * 데이터 전달에 사용
 * Form은 컨트롤러까지 제한
 */
@Getter
@Setter
public class JoinForm {
    // 로그인 ID
    private String loginId;
    // 비밀번호
    private String password;
    // 이름
    private String name;
    // 핸드폰
    private String phone;
    // 이메일
    private String email;
}
