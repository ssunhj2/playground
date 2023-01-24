package com.xun.playground.join.entity;

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
public class JoinEntity {
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

    public JoinEntity(){}

    @Builder
    public JoinEntity(String loginId, String password, String name, String phone, String email, String enterBy){
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.enterBy = enterBy;
    }
}
