package com.xun.playground.common.file.service;

import com.xun.playground.common.file.domain.FileDomain;
import com.xun.playground.common.file.dto.FileDTO;
import com.xun.playground.common.file.repository.FileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 *
 */
@Service
@Transactional
public class FileService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private FileRepository fileRepository;
    
    @Autowired
    public FileService(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    /**
     * 첨부파일 저장
     * @param fileDto
     * @return
     */
    public void saveFile(FileDTO fileDto, MultipartFile files){

        try {
            String fileName = files.getOriginalFilename();
            fileDto.setFileName(fileName);

            String savePath = "D:\\files";

            if (!new File(savePath).exists()) {
                try {
                    new File(savePath).mkdir();
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }

            String filePath = savePath + "\\" + fileName;
            files.transferTo(new File(filePath));

            // DB에 저장
            String fileNo = fileRepository.save(fileDto.toEntity()).getFileNo();
        } catch (Exception e){
            logger.error(e.getMessage());
        }

    }

    /**
     * 첨부파일 조회
     * @param fileNo
     * @return
     */
    public FileDTO getFile(String fileNo){
        FileDomain file = fileRepository.findById(fileNo).get();

        FileDTO fileDto = new FileDTO();
        return fileDto;
    }
}
