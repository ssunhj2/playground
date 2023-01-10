package com.xun.playground.horr.story.form;

import com.xun.playground.common.dto.BaseDTO;

public class HorrStForm extends BaseDTO {
    // seq 번호
    private String horrStNo;
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
