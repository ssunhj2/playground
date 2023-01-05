package com.xun.playground.horr.story.service;

import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.repository.HorrStDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Horror Story 상세페이지
 */
@Service
public class HorrStDetailService {
    private final HorrStDetailRepository horrorStoryDetailRepository;

    @Autowired
    public HorrStDetailService(HorrStDetailRepository horrorStoryDetailRepository){
        this.horrorStoryDetailRepository = horrorStoryDetailRepository;
    }

    /**
     * 무서운이야기 상세페이지 데이터 조회
     * @param horrStNo
     * @return
     */
    public Optional<HorrStDomain> findHorrorStoryDetail(String horrStNo){
        return horrorStoryDetailRepository.findHorrorStoryDetail(horrStNo);
    }

}
