package com.xun.playground.horror.story.service;

import com.xun.playground.horror.story.domain.HorrorStoryDomain;
import com.xun.playground.horror.story.repository.HorrorStoryDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Horror Story 상세페이지
 */
@Service
public class HorrorStoryDetailService {
    private final HorrorStoryDetailRepository horrorStoryDetailRepository;

    @Autowired
    public HorrorStoryDetailService(HorrorStoryDetailRepository horrorStoryDetailRepository){
        this.horrorStoryDetailRepository = horrorStoryDetailRepository;
    }

    /**
     * 무서운이야기 상세페이지 데이터 조회
     * @param horrStNo
     * @return
     */
    public HorrorStoryDomain findHorrorStoryDetail(String horrStNo){
        return horrorStoryDetailRepository.findHorrorStoryDetail(horrStNo);
    }

}
