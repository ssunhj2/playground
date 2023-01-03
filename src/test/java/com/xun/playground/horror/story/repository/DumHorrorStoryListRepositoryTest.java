package com.xun.playground.horror.story.repository;

import com.xun.playground.horror.story.domain.HorrorStoryDomain;
import com.xun.playground.horror.story.service.HorrorStoryListService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 무서운이야기 dummy Repository test
 */
public class DumHorrorStoryListRepositoryTest {
    HorrorStoryListService horrorStoryListService;
    DumHorrorStoryListRepository dumRepository;

    @BeforeEach
    public void beforeEach(){
        dumRepository = new DumHorrorStoryListRepository();
        horrorStoryListService = new HorrorStoryListService(dumRepository);
    }

    @Test
    public void findHorrorStoryList(){
        List<HorrorStoryDomain> storyList = dumRepository.findHorrorStoryList();

        Assertions.assertThat(storyList.size()).isEqualTo(2);
    }
}
