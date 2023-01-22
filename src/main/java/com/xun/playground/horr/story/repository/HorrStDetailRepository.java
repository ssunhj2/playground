package com.xun.playground.horr.story.repository;

import com.xun.playground.horr.story.domain.HorrStDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * 무서운이야기 상세 ropository 인터페이스
 */
public interface HorrStDetailRepository extends JpaRepository<HorrStDomain, String> {

    @Modifying
    @Query("UPDATE HorrStDomain s SET s.viewCount = s.viewCount+1 WHERE s.horrStNo = :horrStNo")
    int addViewCount(@Param("horrStNo") String horrStNo);

}
