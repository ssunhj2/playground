package com.xun.playground.common.file.service;

import com.xun.playground.common.file.domain.FileDomain;
import com.xun.playground.common.file.dto.FileDTO;
import com.xun.playground.common.file.repository.FileRepository;
import org.apache.tomcat.util.buf.UriUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.aspectj.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
@Transactional
public class FileLocalService implements FileService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private FileRepository fileRepository;
    private ResourceLoader resourceLoader;

    private final String localPath = "D:\\files";

    @Autowired
    public FileLocalService(FileRepository fileRepository, ResourceLoader resourceLoader){
        this.fileRepository = fileRepository;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void upload(FileDTO fileDto, List<MultipartFile> files){
        if(CollectionUtils.isEmpty(files)) return;

        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            String currDate = now.format(dateTimeFormatter); // yyyyMMdd

            String savePath = localPath + File.separator + currDate; // localPath/yyyyMMdd

            File chkFile = new File(savePath);

            if (!chkFile.exists()) {
                try {
                    chkFile.mkdir();
                } catch (Exception e) {
                    logger.error("Fail mkdir error MSG: " + e.getMessage());
                }
            }

            // 다중 파일처리
            for(MultipartFile file : files){
                String contentType = file.getContentType(); // 파일 확장자
                fileDto.setContentType(contentType);

                String orgFileName = file.getOriginalFilename(); // 파일명
                fileDto.setFileName(orgFileName);

                String newFileName = System.nanoTime() + "_" + orgFileName; // nanoTime_파일명
                fileDto.setFilePath(currDate + File.separator +  newFileName);

                String filePath = savePath + "\\" + newFileName; // localPath/yyyyMMdd/nanoTime_파일명

                // 파일 업로드
                file.transferTo(new File(filePath));

                // DB에 저장
                String fileNo = fileRepository.save(fileDto.toEntity()).getFileNo();
            }

        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Resource> download(String fileNo) throws MalformedURLException {

        try{
            Optional<FileDomain> findFile = fileRepository.findById(fileNo);
            FileDomain file = findFile.orElse(null);
            if(file == null) return null;

            String uploadFileName = file.getFileName();
            String filePath = file.getFilePath();

            UrlResource resource = new UrlResource("file:" +localPath + "\\" + filePath);

            // 인코딩
            String encodedFileName = UriUtils.encode(uploadFileName, StandardCharsets.UTF_8);
            String contentDisposition = "attachment; filename=\"" + encodedFileName + "\"";

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                    .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.getFile().length()))
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM.toString())
                    .body(resource);

        } catch(IOException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    // 메뉴얼 다운로드
    public ResponseEntity<Resource> manualDownload(String uploadFileName){

        try{
            String filePath = "manual\\" + uploadFileName;

            UrlResource resource = new UrlResource("file:" +localPath + "\\" + filePath);

            // 인코딩
            String encodedFileName = UriUtils.encode(uploadFileName, StandardCharsets.UTF_8);
            String contentDisposition = "attachment; filename=\"" + encodedFileName + "\"";

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                    .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.getFile().length()))
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM.toString())
                    .body(resource);

        } catch(IOException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    /**
     * 첨부된 파일들을 조회한다.
     * @param attachType
     * @param attachNo
     * @return
     */
    public List<FileDTO> getAttaches(String attachType, String attachNo){
        List<FileDomain> fileList = fileRepository.findAllByAttachTypeAndAttachNo(attachType, attachNo);
        List<FileDTO> resultList = new ArrayList<>();

        for(FileDomain file: fileList){
            FileDTO fileDto = new FileDTO(file.getFileNo(), file.getFileName(), file.getFilePath(),
                    file.getAttachType(), file.getAttachNo(), file.getContentType(),
                    file.getEnterBy(), file.getEnterDate());

            resultList.add(fileDto);
        }

        return resultList;
    }

}
