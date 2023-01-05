package com.xun.playground.horr.story.repository;

import com.xun.playground.horr.story.domain.HorrStDomain;

import java.util.Optional;

/**
 * 무서운이야기 콘텐츠 ropository 인터페이스
 */
public interface HorrStDetailRepository {
    // 상세페이지 조회
    Optional<HorrStDomain> findHorrorStoryDetail(String horrStNo);
}
