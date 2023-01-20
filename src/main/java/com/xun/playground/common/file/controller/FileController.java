package com.xun.playground.common.file.controller;

import com.xun.playground.common.file.service.FileLocalService;
import com.xun.playground.common.file.service.FileService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/download")
    public ResponseEntity<Resource> download(@RequestParam("fileNo") String fileNo) throws MalformedURLException {
        return fileService.download(fileNo);
    }
}
