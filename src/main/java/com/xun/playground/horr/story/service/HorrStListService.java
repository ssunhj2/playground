package com.xun.playground.horr.story.service;

import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.repository.HorrStListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 무서운이야기 콘텐츠 서비스
 */
@Transactional
public class HorrStListService {
    private final HorrStListRepository horrStListRepository;

    @Autowired
    public HorrStListService(HorrStListRepository horrStListRepository){
        this.horrStListRepository = horrStListRepository;
    }


    /**
     * 무서운이야기 전체 컨텐츠 조회
     */
    public List<HorrStDomain> findHorrorStoryList(){
        return horrStListRepository.findHorrorStoryList();
    }
}
