package com.xun.playground.common.file.repository;

import com.xun.playground.common.file.domain.FileDomain;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 파일첨부 JPA Repository
 */
public interface FileRepository extends JpaRepository<FileDomain, String> {
}
