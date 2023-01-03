package com.xun.playground.horror.story.service;

import com.xun.playground.horror.story.domain.HorrorStoryDomain;
import com.xun.playground.horror.story.repository.HorrorStoryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 무서운이야기 콘텐츠 서비스
 */
@Service
public class HorrorStoryListService {
    private final HorrorStoryListRepository horrorStoryListRepository;

    @Autowired
    public HorrorStoryListService(HorrorStoryListRepository horrorStoryListRepository){
        this.horrorStoryListRepository = horrorStoryListRepository;
    }


    /**
     * 무서운이야기 전체 컨텐츠 조회
     */
    public List<HorrorStoryDomain> findHorrorStoryList(){
        return horrorStoryListRepository.findHorrorStoryList();
    }
}
