package com.xun.playground.common.file.service;

import com.xun.playground.common.file.domain.FileDomain;
import com.xun.playground.common.file.dto.FileDTO;
import com.xun.playground.common.file.repository.FileRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Transactional
public class FileService {
    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    public String saveFile(FileDTO fileDto){

    }

    public FileDTO getFile(){
        FileDomain file;
    }
}
