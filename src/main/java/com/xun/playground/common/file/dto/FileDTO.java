package com.xun.playground.common.file.dto;

import com.xun.playground.common.file.domain.FileDomain;
import lombok.Getter;
import lombok.Setter;

/**
 * 데이터 전송을 위한 FILE DTO
 */
@Getter
@Setter
public class FileDTO {


    public FileDomain toEntity(){
        FileDomain entity = new FileDomain();

        return entity;
    }
}
