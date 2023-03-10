package com.xun.playground.common.base.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 공통적으로 사용되는 속성
 */
@Getter
@Setter
public class BaseDTO {
    // 작성자
    private String enterBy;
    // 작성날짜
    private String enterDate;
    // 수정자
    private String updateBy;
    // 수정날짜
    private String updateDate;

}
