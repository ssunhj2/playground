package com.xun.playground.horr.story.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 무서운이야기 컨텐츠
 */
@Entity
@Table(name="HORROR_STORY")
public class HorrStDomain {
    // horror Story No
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="HORR_ST_NO")
    private String horrStNo;
    // 조회수
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
    @Column(name="ENTER_DATE")
    private LocalDateTime enterDate = LocalDateTime.now();
    // 수정자 id
    @Column(name="UPDATE_BY")
    private String updateBy;
    // 수정날짜
    @UpdateTimestamp
    @Column(name="UPDATE_DATE")
    private LocalDateTime updateDate;


    public String getHorrStNo() {
        return horrStNo;
    }

    public void setHorrStNo(String horrStNo) {
        this.horrStNo = horrStNo;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEnterBy() {
        return enterBy;
    }

    public void setEnterBy(String enterBy) {
        this.enterBy = enterBy;
    }

    public LocalDateTime getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(LocalDateTime enterDate) {
        this.enterDate = enterDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
