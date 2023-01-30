package com.xun.playground.common.user.entity;

import lombok.Getter;

import javax.persistence.*;

/**
 * 사용자 Entity
 */
@Entity
@Getter
@Table(name="MEMBER")
public class UserEntity {
    @Id
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
    // 로그인가능 여부
    @Column(name="IS_LOGIN")
    private String isLogin;
}
