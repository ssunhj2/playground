package com.xun.playground.common.file.repository;

import com.xun.playground.common.file.domain.FileDomain;
import com.xun.playground.common.file.dto.FileDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 파일첨부 JPA Repository
 */
public interface FileRepository extends JpaRepository<FileDomain, String> {
    // attach type, attach no 을 조건으로 데이터를 조회
    List<FileDomain> findAllByAttachTypeAndAttachNo(String attachType, String attachNo);
}
