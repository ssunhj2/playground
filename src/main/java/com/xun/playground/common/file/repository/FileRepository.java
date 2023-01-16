package com.xun.playground.common.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.File;

/**
 * 파일첨부 JPA Repository
 */
public interface FileRepository extends JpaRepository<File, Long> {
}
