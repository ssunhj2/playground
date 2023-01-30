package com.xun.playground.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 회원가입 Entity
 */
@Entity
@Getter
@Table(name="MEMBER")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MEMBER_NO")
    private String memberNo;
    // 로그인 ID
    @Column(name="LOGIN_ID")
    private String loginId;
    // 비밀번호
    @Column(name="PASSWORD")
    private String password;
    // 이름
    @Column(name="NAME")
    private String name;
    // 핸드폰
    @Column(name="PHONE")
    private String phone;
    // 이메일
    @Column(name="EMAIL")
    private String email;
    // 주소
    @Column(name="ADDRESS")
    private String address;
    // 취미
    @Column(name="HOBBY")
    private String hobby;
    //로그인 가능여부
    @Column(name="IS_LOGIN")
    private String isLogin;

    @Column(name="ENTER_BY")
    private String enterBy;
    // 작성날짜
    @CreationTimestamp
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
    @Column(name="ENTER_DATE")
    private LocalDate enterDate;
    // 수정자 id
    @Column(name="UPDATE_BY")
    private String updateBy;
    // 수정날짜
    @UpdateTimestamp
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
    @Column(name="UPDATE_DATE")
    private LocalDate updateDate;

    public MemberEntity(){}

    @Builder
    public MemberEntity(String loginId, String password, String name, String phone, String email, String address, String hobby, String isLogin, String enterBy){
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.hobby = hobby;
        this.isLogin = isLogin;
        this.enterBy = enterBy;
    }

    // 수정
    public void update(String name, String phone, String email, String address, String hobby, String updateBy){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.hobby = hobby;
        this.updateBy = updateBy;
    }
}
