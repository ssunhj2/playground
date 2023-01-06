package com.xun.playground.horr.story.repository;

import com.xun.playground.horr.story.domain.HorrStDomain;

import java.util.ArrayList;
import java.util.List;

/**
 * 무서운이야기 콘텐츠 ropository
 * 더미데이터를 사용한다.
 * DB 연결 전에 사용한다.
 */

public class DumHorrStListRepository implements HorrStListRepository {


    public List<HorrStDomain> findHorrorStoryList() {
        return makeTempDummyList();
    }

    /**
     * 게시판 전체조회를 위한 더미 데이터 생성
     * @return
     */
    private List<HorrStDomain> makeTempDummyList(){
        List<HorrStDomain> storyList = new ArrayList<>();

        HorrStDomain story = new HorrStDomain();
        story.setHorrStNo("1");
        story.setViewCount("3");
        story.setTitle("우리 지역에 전해내려오는 무시무시한 이야기");
        story.setEnterBy("xunxou");
        storyList.add(story);

        HorrStDomain story2 = new HorrStDomain();
        story2.setHorrStNo("2");
        story2.setViewCount("30");
        story2.setTitle("공포 실화");
        story2.setEnterBy("hello");
        story2.setEnterBy("hello");
        storyList.add(story2);

        return storyList;

    }
}
