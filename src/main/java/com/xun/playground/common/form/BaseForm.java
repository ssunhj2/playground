package com.xun.playground.common.form;

import java.time.LocalDate;

/**
 * 공통적으로 사용되는 form
 */
public class BaseForm {
    // 작성자
    private String enterBy;
    // 작성날짜
    private LocalDate enterDate;
    // 수정자
    private String updateBy;
    // 수정날짜
    private LocalDate updateDate;

    public String getEnterBy() {
        return enterBy;
    }

    public void setEnterBy(String enterBy) {
        this.enterBy = enterBy;
    }

    public LocalDate getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(LocalDate enterDate) {
        this.enterDate = enterDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }
}
