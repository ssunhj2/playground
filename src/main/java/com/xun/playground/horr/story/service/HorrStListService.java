package com.xun.playground.horr.story.service;

import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.repository.HorrStListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 무서운이야기 콘텐츠 서비스
 */
public class HorrStListService {
    private final HorrStListRepository horrorStoryListRepository;

    @Autowired
    public HorrStListService(HorrStListRepository horrorStoryListRepository){
        this.horrorStoryListRepository = horrorStoryListRepository;
    }


    /**
     * 무서운이야기 전체 컨텐츠 조회
     */
    public List<HorrStDomain> findHorrorStoryList(){
        return horrorStoryListRepository.findHorrorStoryList();
    }
}
