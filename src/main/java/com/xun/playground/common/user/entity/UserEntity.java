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
}
