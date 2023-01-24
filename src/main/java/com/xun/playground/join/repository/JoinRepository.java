package com.xun.playground.join.repository;

import com.xun.playground.join.entity.JoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 회원가입 Repository
 */
public interface JoinRepository extends JpaRepository<JoinEntity, String> {

}
