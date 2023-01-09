package com.xun.playground.horr.story.form;

import com.xun.playground.common.form.BaseForm;

public class HorrStForm extends BaseForm {
    // seq 번호
    private String horrStNo;
    // origin제목
    private String oldTitle;
    // 제목
    private String title;
    // origin 내용
    private String oldContent;
    // 내용
    private String content;

    public String getHorrStNo() {
        return horrStNo;
    }

    public void setHorrStNo(String horrStNo) {
        this.horrStNo = horrStNo;
    }

    public String getOldTitle() {
        return oldTitle;
    }

    public void setOldTitle(String oldTitle) {
        this.oldTitle = oldTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOldContent() {
        return oldContent;
    }

    public void setOldContent(String oldContent) {
        this.oldContent = oldContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
