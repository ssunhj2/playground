package com.xun.playground.horr.story.repository;

import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.service.HorrStListService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 무서운이야기 dummy Repository test
 */
public class DumHorrStListRepositoryTest {
    HorrStListService horrorStoryListService;
    DumHorrStListRepository dumRepository;

    @BeforeEach
    public void beforeEach(){
        dumRepository = new DumHorrStListRepository();
        horrorStoryListService = new HorrStListService(dumRepository);
    }

    @Test
    public void findHorrorStoryList(){
        List<HorrStDomain> storyList = dumRepository.findHorrorStoryList();

        Assertions.assertThat(storyList.size()).isEqualTo(2);
    }
}
