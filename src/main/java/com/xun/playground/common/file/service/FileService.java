package com.xun.playground.common.file.service;

import com.xun.playground.common.file.dto.FileDTO;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.util.List;

/**
 * 파일 업로드 & 다운로드 인터페이스
 */
public interface FileService {
    // 파일 업로드
    void upload(FileDTO fileDto, List<MultipartFile> files);

    // 파일 다운로드
    ResponseEntity<Resource> download(String fileNo) throws MalformedURLException;
}
