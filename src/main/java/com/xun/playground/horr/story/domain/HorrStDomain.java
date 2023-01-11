package com.xun.playground.horr.story.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import groovy.transform.builder.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 무서운이야기 entity(DB관련 사용)
 * ENTITY
 * 1. 테이블 내에 존재하는 속성만 정의한다.
 * 2. 데이터 전달에 사용하지 않는다.
 */
@Getter
@Entity
@Table(name="HORROR_STORY")
public class HorrStDomain {
    // horror Story No
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="HORR_ST_NO")
    private String horrStNo;
    // 조회수
    @ColumnDefault("0")
    @Column(name="VIEW_COUNT")
    private String viewCount;
    // 제목
    @Column(name="TITLE")
    private String title;
    // 내용
    @Column(name="CONTENT")
    private String content;
    // 작성자 id
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

    public HorrStDomain(){}
    @Builder
    public HorrStDomain(String viewCount, String title, String content, String enterBy){
        this.viewCount = viewCount;
        this.title = title;
        this.content = content;
        this.enterBy = enterBy;
    }

    // 수정
    public void update(String title, String content, String updateBy){
        this.title = title;
        this.content = content;
        this.updateBy = updateBy;
    }
}
