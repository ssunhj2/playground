package com.xun.playground.common.file.dto;

import com.xun.playground.common.base.dto.BaseDTO;
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
    // 파일경로
    private String filePath;
    // 첨부위치
    private String attachType;
    // 첨부위치 번호
    private String attachNo;
    // 확장자
    private String contentType;

    public FileDTO(){}

    public FileDTO(String fileNo, String fileName, String filePath, String attachType, String attachNo,
                   String contentType, String enterBy, LocalDate enterDate){
        this.fileNo = fileNo;
        this.fileName = fileName;
        this.filePath = filePath;
        this.attachType = attachType;
        this.attachNo = attachNo;
        this.contentType = contentType;
        this.setEnterBy(enterBy);
        this.setEnterDate(enterDate);
    }

    public FileDTO fromEntity(FileDomain entity){
        return new FileDTO(entity.getFileNo(), entity.getFileName(), entity.getFilePath(),
                entity.getAttachType(), entity.getAttachNo(), entity.getContentType(),
                entity.getEnterBy(), entity.getEnterDate());
    }


    public FileDomain toEntity(){
        return new FileDomain(fileNo, fileName, filePath, attachType, attachNo, contentType, getEnterBy());
    }
}
