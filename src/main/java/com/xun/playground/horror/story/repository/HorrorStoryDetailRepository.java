package com.xun.playground.horror.story.repository;

import com.xun.playground.horror.story.domain.HorrorStoryDomain;

/**
 * 무서운이야기 콘텐츠 ropository 인터페이스
 */
public interface HorrorStoryDetailRepository {
    // 상세페이지 조회
    HorrorStoryDomain findHorrorStoryDetail(String horrStNo);
}
