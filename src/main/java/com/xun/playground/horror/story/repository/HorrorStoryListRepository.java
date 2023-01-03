package com.xun.playground.horror.story.repository;

import com.xun.playground.horror.story.domain.HorrorStoryDomain;

import java.util.List;

/**
 * 무서운이야기 콘텐츠 ropository 인터페이스
 */
public interface HorrorStoryListRepository {
    // 목록 전체조회
    List<HorrorStoryDomain> findHorrorStoryList();
    // todo
    // 가장 조회수 높은 글 (top1 ~ top5)
}
