package com.xun.playground.horr.story.dto;

import com.xun.playground.common.base.dto.BaseDTO;
import com.xun.playground.horr.story.entity.HorrStEntity;
import com.xun.playground.horr.story.form.HorrStForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 무서운이야기 DTO
 * DTO는 데이터 전달 목적으로 사용
 * 컨트롤러, 서비스, repository 에서 사용
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
    // 삭제여부
    private String isDelete;
    // writer memberNo (writer 비교시에만 사용)
    private String memberNo;


    public HorrStDTO(String viewCount, String title, String content, String enterBy){
        this.viewCount = viewCount;
        this.title = title;
        this.content = content;
        this.setEnterBy(enterBy);
    }

    // form 값을 DTO에 set
    public HorrStDTO(HorrStForm form){
        this.horrStNo = form.getHorrStNo();
        this.title = form.getTitle();
        this.content = form.getContent();
        this.setEnterBy(form.getEnterBy());
    }

    // entity 값을 DTO에 set
    public HorrStDTO(HorrStEntity entity){
        this.horrStNo = entity.getHorrStNo();
        this.viewCount = entity.getViewCount();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.isDelete = entity.getIsDelete();
        this.setEnterBy(entity.getEnterBy());
        this.setEnterDate(entity.getEnterDate().toString());
        this.setUpdateBy(entity.getUpdateBy());
        this.setUpdateDate(entity.getUpdateDate().toString());
    }

    // HorrStDTO 객체를 entity 객체로 변환하여 반환한다.
    public HorrStEntity toEntity(){
        return new HorrStEntity(viewCount, title, content, getEnterBy());
    }

}
