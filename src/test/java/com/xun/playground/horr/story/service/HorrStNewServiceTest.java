package com.xun.playground.horr.story.service;

import com.xun.playground.horr.story.entity.HorrStEntity;
import com.xun.playground.horr.story.dto.HorrStDTO;
import com.xun.playground.horr.story.repository.HorrStNewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 무서운이야기 new 서비스 테스트
 */
@SpringBootTest
@Transactional
public class HorrStNewServiceTest {
    @Autowired
    HorrStNewService horrStNewService;
    @Autowired HorrStNewRepository horrStNewRepository;

    @Test
    void 저장(){
        //given
        HorrStDTO dummy = new HorrStDTO("0", "무서운 제목", "무서운 내용", "xunxou");

        // when
        HorrStDTO horrStDTO = horrStNewService.saveStory(dummy);

        //then
        HorrStEntity result = horrStNewRepository.findById(horrStDTO.getHorrStNo()).get();
        assertThat(result.getViewCount()).isEqualTo("0");
        assertThat(result.getTitle()).isEqualTo("무서운 제목");
        assertThat(result.getContent()).isEqualTo("무서운 내용");
        assertThat(result.getEnterBy()).isEqualTo("xunxou");
    }

    @Test
    void 수정(){
        //given
        HorrStEntity dummy = new HorrStEntity("0", "무서운 제목2", "무서운 내용2", "xunxou");
        HorrStEntity entity = horrStNewRepository.save(dummy); // 저장

        // when
        HorrStDTO horrStDTO = new HorrStDTO(entity);
        horrStDTO.setTitle("무서운 제목22");
        horrStDTO.setContent("무서운 내용22");
        horrStDTO.setEnterBy("xunxou");

        horrStNewService.saveStory(horrStDTO); // 수정

        //then
        HorrStEntity result = horrStNewRepository.findById(horrStDTO.getHorrStNo()).get();
        assertThat(result.getTitle()).isEqualTo("무서운 제목22");
        assertThat(result.getContent()).isEqualTo("무서운 내용22");
        assertThat(result.getEnterBy()).isEqualTo("xunxou");

    }

}
