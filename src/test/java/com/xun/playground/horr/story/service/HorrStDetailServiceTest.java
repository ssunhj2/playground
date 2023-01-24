package com.xun.playground.horr.story.service;

import com.xun.playground.horr.story.entity.HorrStEntity;
import com.xun.playground.horr.story.dto.HorrStDTO;
import com.xun.playground.horr.story.repository.HorrStDetailRepository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;



/**
 * 무서운이야기 상세 서비스 테스트
 */
@SpringBootTest
@Transactional
public class HorrStDetailServiceTest {

    @Autowired HorrStDetailService horrStDetailService;
    @Autowired HorrStDetailRepository horrStDetailRepository;

    @Test
    void 상세조회(){
        //given
        HorrStEntity dummy = new HorrStEntity("0", "무서운 제목", "무서운 내용", "xunxou");
        HorrStEntity story = horrStDetailRepository.save(dummy);

        // when
        HorrStDTO result = horrStDetailService.findDetail(story.getHorrStNo());

        //then
        assertThat(result.getViewCount()).isEqualTo(story.getViewCount());
        assertThat(result.getTitle()).isEqualTo(story.getTitle());
        assertThat(result.getContent()).isEqualTo(story.getContent());
        assertThat(result.getEnterBy()).isEqualTo(story.getEnterBy());
    }

    @Test
    void 삭제(){
        //given
        HorrStEntity entity = new HorrStEntity("0", "무서운 제목", "무서운 내용", "xunxou");

        HorrStEntity story = horrStDetailRepository.save(entity);

        horrStDetailService.deleteStory(story.getHorrStNo());

    }
}
