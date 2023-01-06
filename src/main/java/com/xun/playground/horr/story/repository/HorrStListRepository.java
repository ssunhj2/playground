package com.xun.playground.horr.story.repository;

import com.xun.playground.horr.story.domain.HorrStDomain;

import java.util.List;

/**
 * 무서운이야기 목록 ropository 인터페이스
 */
public interface HorrStListRepository {
    // 목록 전체조회
    List<HorrStDomain> findHorrorStoryList();
    // todo
    // 가장 조회수 높은 글 (top1 ~ top5)
}
