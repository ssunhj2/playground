package com.xun.playground.horr.story.dto;

import com.xun.playground.common.dto.BaseDTO;
import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.form.HorrStForm;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 무서운이야기 DTO
 * 데이터 전달 목적으로만 사용
 */
@Getter
@Setter
@NoArgsConstructor
public class HorrStDTO extends BaseDTO {
    // horror Story No
    private String horrStNo;
    // 조회수
    private String viewCount;
    // 제목
    private String title;
    // 내용
    private String content;


    public HorrStDTO(String viewCount, String title, String content, String enterBy){
        this.viewCount = viewCount;
        this.title = title;
        this.content = content;
        this.setEnterBy(enterBy);
    }

    public HorrStDTO(HorrStForm form){
        this.horrStNo = form.getHorrStNo();
        this.title = form.getTitle();
        this.content = form.getContent();
        this.setEnterBy(form.getEnterBy());
    }

    public HorrStDTO(HorrStDomain entity){
        this.horrStNo = entity.getHorrStNo();
        this.viewCount = entity.getViewCount();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.setEnterBy(entity.getEnterBy());
        this.setEnterDate(entity.getEnterDate());
        this.setUpdateBy(entity.getUpdateBy());
        this.setUpdateDate(entity.getUpdateDate());
    }

    // HorrStDTO 객체를 entity 객체로 return 한다.
    public HorrStDomain toEntity(){
        return new HorrStDomain(viewCount, title, content, getEnterBy());
    }

}
