package com.xun.playground.horror.story.repository;

import com.xun.playground.horror.story.domain.HorrorStoryDomain;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 무서운이야기 콘텐츠 ropository
 * 더미데이터를 사용한다.
 * DB 연결 전에 사용한다.
 */
@Repository
public class DumHorrorStoryListRepository implements HorrorStoryListRepository {

    @Override
    public List<HorrorStoryDomain> findHorrorStoryList() {
        return makeTempDummyList();
    }

    // 더미 데이터
    private List<HorrorStoryDomain> makeTempDummyList(){
        List<HorrorStoryDomain> storyList = new ArrayList<>();

        HorrorStoryDomain story = new HorrorStoryDomain();
        story.setId("xunxou");
        story.setName("햇님이");
        story.setViewCount("3");
        story.setTitle("우리 지역에 전해내려오는 무시무시한 이야기");
        story.setEnterDate("2023-01-03");
        storyList.add(story);

        HorrorStoryDomain story2 = new HorrorStoryDomain();
        story2.setId("hello");
        story2.setName("안녕");
        story2.setViewCount("30");
        story2.setTitle("공포 실화");
        story2.setEnterDate("2023-01-02");
        storyList.add(story2);

        return storyList;

    }
}