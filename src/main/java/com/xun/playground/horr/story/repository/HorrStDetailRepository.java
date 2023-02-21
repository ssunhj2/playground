package com.xun.playground.horr.story.repository;

import com.xun.playground.horr.story.entity.HorrStEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * 무서운이야기 상세 ropository 인터페이스
 */
public interface HorrStDetailRepository extends JpaRepository<HorrStEntity, String> {

    /* 삭제 수행
     * 조건에 enterBy 조건 추가하여 작성자만 삭제 가능하도록 처리
     * */
    @Modifying
    @Query("UPDATE HorrStEntity s SET s.isDelete = 'Y' WHERE s.horrStNo = :horrStNo AND s.enterBy = :enterBy")
    int deleteStory(@Param("horrStNo") String horrStNo, @Param("enterBy") String enterBy);

    @Modifying
    @Query("UPDATE HorrStEntity s SET s.viewCount = s.viewCount+1 WHERE s.horrStNo = :horrStNo")
    int addViewCount(@Param("horrStNo") String horrStNo);

}
