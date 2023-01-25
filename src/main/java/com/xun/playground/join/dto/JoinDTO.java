package com.xun.playground.join.dto;

import com.xun.playground.common.dto.BaseDTO;
import com.xun.playground.join.entity.JoinEntity;
import com.xun.playground.join.form.JoinForm;
import lombok.Getter;
import lombok.Setter;

/**
 * 회원가입 DTO
 * 데이터 전달에 사용
 * 컨트롤러, 서비스, repository 에서 사용
 */
@Getter
@Setter
public class JoinDTO extends BaseDTO {
    // 회원번호
    private String userNo;
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
    
    public JoinDTO(){}
    
    // form 값을 DTO에 set
    public JoinDTO(JoinForm form){
        this.loginId = form.getLoginId();
        this.password = form.getPassword();
        this.name = form.getName();
        this.phone = form.getPhone();
        this.email = form.getEmail();
    }

    public JoinDTO(String loginId, String password, String name, String phone, String email, String enterBy){
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.setEnterBy(enterBy);
    }

    // DTO값을 entity 객체로 변환하여 반환한다.
    public JoinEntity toEntity(){
        return new JoinEntity(loginId, password, name, phone, email, getEnterBy());
    }

}
