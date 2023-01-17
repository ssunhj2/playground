package com.xun.playground.common.file.dto;

import com.xun.playground.common.dto.BaseDTO;
import com.xun.playground.common.file.domain.FileDomain;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * 데이터 전송을 위한 FILE DTO
 */
@Getter
@Setter
public class FileDTO extends BaseDTO {
    // 파일번호
    private String fileNo;
    // 파일명
    private String fileName;
    // 파일타입
    private String fileType;

    private String attachType;

    private String attachNo;

    public FileDTO(){}

    public FileDTO(String fileNo, String fileName, String attachType, String attachNo,  String enterBy, LocalDate enterDate){
        this.fileNo = fileNo;
        this.fileName = fileName;
        this.attachType = attachType;
        this.attachNo = attachNo;
        this.setEnterBy(enterBy);
        this.setEnterDate(enterDate);
    }

    public FileDomain toEntity(){
        return new FileDomain(fileNo, fileName, attachType, attachNo, getEnterBy());
    }
}
