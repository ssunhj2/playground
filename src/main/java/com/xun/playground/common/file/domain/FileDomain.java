package com.xun.playground.common.file.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 파일첨부 Entity
 */
@Getter
@Entity
@Table(name="FILE")
public class FileDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FILE_NO")
    private String fileNo;
    @Column(name="FILE_NAME")
    private String fileName;
    @Column(name = "FILE_PATH")
    private String filePath;
    @Column(name="ATTACH_TYPE")
    private String attachType;
    @Column(name="ATTACH_NO")
    private String attachNo;
    // 확장자
    @Column(name="CONTENT_TYPE")
    private String contentType;
    @Column(name="ENTER_BY")
    private String enterBy;
    // 작성날짜
    @CreationTimestamp
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
    @Column(name="ENTER_DATE")
    private LocalDateTime enterDate;
    // 수정자 id
    @Column(name="UPDATE_BY")
    private String updateBy;
    // 수정날짜
    @UpdateTimestamp
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
    @Column(name="UPDATE_DATE")
    private LocalDateTime updateDate;

    public FileDomain(){}

    public FileDomain(String fileNo, String fileName, String filePath,
                      String attachType, String attachNo, String contentType, String enterBy){
        this.fileNo = fileNo;
        this.fileName = fileName;
        this.filePath = filePath;
        this.attachType = attachType;
        this.attachNo = attachNo;
        this.contentType = contentType;
        this.enterBy = enterBy;
    }

    
}
