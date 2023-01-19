package com.xun.playground.common.file.controller;

import com.xun.playground.common.file.service.FileLocalService;
import com.xun.playground.common.file.service.FileService;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.MalformedURLException;

/**
 * 첨부파일 controller
 */
@Controller
public class FileController {

    private final FileLocalService fileService;
    public FileController(FileLocalService fileService){
        this.fileService = fileService;
    }

    @PostMapping("/download")
    public ResponseEntity download(@RequestParam("fileNo") String fileNo) throws MalformedURLException {
        return fileService.download(fileNo);
    }
}
