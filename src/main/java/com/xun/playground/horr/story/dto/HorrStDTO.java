package com.xun.playground.horr.story.dto;

import com.xun.playground.common.dto.BaseDTO;

/**
 * 무서운이야기 DTO (데이터 전달 목적으로만 사용)
 */
public class HorrStDTO extends BaseDTO {
    // horror Story No
    private String horrStNo;
    // 조회수
    private String viewCount;
    // 제목
    private String title;
    // 내용
    private String content;

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
}
