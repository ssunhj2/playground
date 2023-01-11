package com.xun.playground.horr.story.service;

import com.xun.playground.horr.story.dto.HorrStDTO;
import com.xun.playground.horr.story.repository.HorrStListRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

/**
 * 무서운이야기 목록 서비스 테스트
 */
@SpringBootTest
@Transactional
public class HorrStListServiceTest {

    @Autowired HorrStListService horrStListService;
    @Autowired HorrStListRepository horrStListRepository;

    @Test
    void 전체조회(){
        //given
        long listCount = horrStListRepository.count();

        // when
        List<HorrStDTO> storyList = horrStListService.findAllList();

        //then
        assertThat(storyList.size()).isEqualTo(listCount);
    }
}
