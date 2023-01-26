package com.xun.playground.member.dto;

import com.xun.playground.common.base.dto.BaseDTO;
import com.xun.playground.member.entity.MemberEntity;
import com.xun.playground.member.form.MemberForm;
import lombok.Getter;
import lombok.Setter;

/**
 * 회원가입 DTO
 * 데이터 전달에 사용
 * 컨트롤러, 서비스, repository 에서 사용
 */
@Getter
@Setter
public class MemberDTO extends BaseDTO {
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
    // 주소
    private String address;
    // 취미
    private String hobby;
    
    public MemberDTO(){}
    
    // form 값을 DTO에 set
    public MemberDTO(MemberForm form){
        this.loginId = form.getLoginId();
        this.password = form.getPassword();
        this.name = form.getName();
        this.phone = form.getPhone();
        this.email = form.getEmail();
        this.address = form.getAddress();
        this.hobby = form.getHobby();
    }

    // eneity값을 DTO에 set
    public MemberDTO(MemberEntity memberEntity){
        this.loginId = memberEntity.getLoginId();
        this.password = memberEntity.getPassword();
        this.name = memberEntity.getName();
        this.phone = memberEntity.getPhone();
        this.email = memberEntity.getEmail();
        this.address = memberEntity.getAddress();
        this.hobby = memberEntity.getHobby();
    }

    public MemberDTO(String loginId, String password, String name, String phone, String email, String address, String hobby, String enterBy){
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.hobby = hobby;
        this.setEnterBy(enterBy);
    }

    // DTO값을 entity 객체로 변환하여 반환한다.
    public MemberEntity toEntity(){
        return new MemberEntity(loginId, password, name, phone, email, address, hobby, getEnterBy());
    }

}
