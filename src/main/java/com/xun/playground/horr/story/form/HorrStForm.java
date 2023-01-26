package com.xun.playground.horr.story.form;

import com.xun.playground.common.base.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * 게시글 작성
 * 데이터 전달에 사용
 * Form은 컨트롤러까지 제한
 */
@Getter
@Setter
public class HorrStForm extends BaseDTO {
    // seq 번호
    private String horrStNo;
    // 제목
    private String title;
    // 내용
    private String content;

}
