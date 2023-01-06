package com.xun.playground.horr.story.service;

import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.repository.HorrStNewRepository;
import com.xun.playground.horr.story.repository.JpaHorrStNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 무서운이야기 게시판 글쓰기 service
 */
@Transactional
public class HorrStNewService {
    private final HorrStNewRepository horrStNewRepository;

    @Autowired
    public HorrStNewService(HorrStNewRepository horrStNewRepository){
        this.horrStNewRepository = horrStNewRepository;
    }

    /**
     * 무서운이야기 글 저장
     * @param story
     * @return
     */
    public HorrStDomain createStory(HorrStDomain story){
        return horrStNewRepository.createStory(story);
    }
}
