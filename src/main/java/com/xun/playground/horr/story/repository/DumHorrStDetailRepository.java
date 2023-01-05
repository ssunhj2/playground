package com.xun.playground.horr.story.repository;

import com.xun.playground.horr.story.domain.HorrStDomain;

import java.util.Optional;

/**
 * 무서운이야기 콘텐츠 상세 ropository
 * 더미데이터를 사용한다.
 * DB 연결 전에 사용한다.
 */

public class DumHorrStDetailRepository implements HorrStDetailRepository {


    public Optional<HorrStDomain> findHorrorStoryDetail(String horrStNo) {
        return makeTempDummyDetail(horrStNo);
    }

    /**
     * 게시판 상세 조회를 위한 더미데이터 생성
     * @param horrStNo
     * @return
     */
    private Optional<HorrStDomain> makeTempDummyDetail(String horrStNo){
        HorrStDomain story = new HorrStDomain();
        story.setHorrStNo(horrStNo);
        story.setViewCount("3");
        story.setTitle("우리 지역에 전해내려오는 무시무시한 이야기");
        story.setEnterBy("hello");
        story.setEnterDate("2023-01-03");

        return Optional.ofNullable(story);
    }
}
