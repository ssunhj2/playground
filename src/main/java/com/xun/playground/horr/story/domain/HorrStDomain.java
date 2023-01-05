package com.xun.playground.horr.story.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 무서운이야기 컨텐츠
 */
@Entity
public class HorrStDomain {
    // horror Story No
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String horrStNo;
    // 조회수
    private String viewCount;
    // 제목
    private String title;
    // 내용
    private String content;
    // 작성자 id
    private String enterBy;
    // 작성날짜
    private String enterDate;

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

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }
}
