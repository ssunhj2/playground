package com.xun.playground.horr.story.repository;

import com.xun.playground.horr.story.domain.HorrStDomain;

/**
 * 무서운이야기 글쓰기 ropository 인터페이스
 */
public interface HorrStNewRepository {
    // 글 저장
    HorrStDomain createStory(HorrStDomain story);
    // 글 수정
    HorrStDomain modifyStory(HorrStDomain story);
}
