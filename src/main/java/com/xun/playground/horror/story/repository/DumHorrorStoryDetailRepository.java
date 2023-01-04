package com.xun.playground.horror.story.repository;

import com.xun.playground.horror.story.domain.HorrorStoryDomain;
import org.springframework.stereotype.Repository;

/**
 * 무서운이야기 콘텐츠 상세 ropository
 * 더미데이터를 사용한다.
 * DB 연결 전에 사용한다.
 */
@Repository
public class DumHorrorStoryDetailRepository implements HorrorStoryDetailRepository{

    @Override
    public HorrorStoryDomain findHorrorStoryDetail(String horrStNo) {
        return makeTempDummyDetail(horrStNo);
    }

    /**
     * 게시판 상세 조회를 위한 더미데이터 생성
     * @param horrStNo
     * @return
     */
    private HorrorStoryDomain makeTempDummyDetail(String horrStNo){
        HorrorStoryDomain story = new HorrorStoryDomain();
        story.setHorrStNo(horrStNo);
        story.setUserName("햇님이");
        story.setViewCount("3");
        story.setTitle("우리 지역에 전해내려오는 무시무시한 이야기");
        story.setEnterDate("2023-01-03");

        return story;
    }
}
