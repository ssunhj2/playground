package com.xun.playground.common.file.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 파일첨부 Entity
 */
@Getter
@Entity
@Table
public class FileDomain {
    private String fileId;
    private String orgFileNAme;
    private String fileName;
    private String filePath;

    public FileDomain(){}

    public FileDomain(String fileId){
        this.fileId = fileId;
    }

    
}
