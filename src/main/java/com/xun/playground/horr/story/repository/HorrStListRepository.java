package com.xun.playground.horr.story.repository;

import com.xun.playground.horr.story.domain.HorrStDomain;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 무서운이야기 목록 ropository 인터페이스
 */
public interface HorrStListRepository extends JpaRepository<HorrStDomain, String> {

}
