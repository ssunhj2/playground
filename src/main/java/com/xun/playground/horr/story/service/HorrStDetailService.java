package com.xun.playground.horr.story.service;

import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.repository.HorrStDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Horror Story 상세페이지
 */
@Transactional
public class HorrStDetailService {
    private final HorrStDetailRepository horrStDetailRepository;

    @Autowired
    public HorrStDetailService(HorrStDetailRepository horrStDetailRepository){
        this.horrStDetailRepository = horrStDetailRepository;
    }

    /**
     * 무서운이야기 상세페이지 데이터 조회
     * @param horrStNo
     * @return
     */
    public Optional<HorrStDomain> findHorrorStoryDetail(String horrStNo){
        return horrStDetailRepository.findHorrorStoryDetail(horrStNo);
    }

   public void deleteStory(String horrStNo){
       horrStDetailRepository.deleteStory(horrStNo);
   }
}
