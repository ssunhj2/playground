package com.xun.playground.horr.story.repository;

import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.service.HorrStDetailService;
import com.xun.playground.horr.story.service.HorrStListService;
import com.xun.playground.horr.story.service.HorrStNewService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 무서운이야기 서비스 스프링 통합테스트
 */
@SpringBootTest
@Transactional
public class HorrStIntegTest {
    // 목록 서비스
    @Autowired
    HorrStListService listService;
    @Autowired
    HorrStListRepository listRepository;
    // 상세 서비스
    @Autowired
    HorrStDetailService detailService;
    @Autowired
    HorrStDetailRepository detailRepository;

    @Autowired
    HorrStNewService newService;
    @Autowired
    HorrStNewRepository newRepository;


    /**
     * 목록
     */
    // 조회



    /**
     * 상세
     */

    // 상세페이지 조회


    // 삭제
    @Test
    void 삭제(){
        // given
        HorrStDomain story = newTestStory();
        String horrStNo = story.getHorrStNo();

        int originSize = listService.findHorrorStoryList().size();

        // when
        detailService.deleteStory(horrStNo);

        // then
        assertThat(listService.findHorrorStoryList().size()).isEqualTo(originSize-1);
    }

    // 수정
    @Test
    void 수정(){
        // given
        HorrStDomain story = newTestStory();
        String horrStNo = story.getHorrStNo();
        story.setTitle("제목수정합니다."); // 수정

        // when
        // detailService. 수정

        // then
        // 조회해서 제목이 일치하는지 확인하기
        assertThat("").isEqualTo(story.getTitle());
    }


    /**
     * new
     */
    // 게시글 저장


    /**
     * 공통
     */
    // 테스트를 위한 story 생성
    private HorrStDomain newTestStory(){
        HorrStDomain story = new HorrStDomain();
        story.setViewCount("3");
        story.setTitle("우리 지역에 전해내려오는 무시무시한 이야기");
        story.setEnterBy("hello");

        // 저장하고 key 받아오기
        HorrStDomain result = newRepository.createStory(story);

        return result;
    }
}
