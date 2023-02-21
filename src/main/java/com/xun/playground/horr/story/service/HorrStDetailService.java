package com.xun.playground.horr.story.service;

import com.xun.playground.horr.story.entity.HorrStEntity;
import com.xun.playground.horr.story.dto.HorrStDTO;
import com.xun.playground.horr.story.model.HorrStDetailMapper;
import com.xun.playground.horr.story.repository.HorrStDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Horror Story 상세페이지 Service
 */
@Transactional
@Service
public class HorrStDetailService {
    private final HorrStDetailRepository horrStDetailRepository;

    private final HorrStDetailMapper horrStDetailMapper;

    @Autowired
    public HorrStDetailService(HorrStDetailRepository horrStDetailRepository, HorrStDetailMapper horrStDetailMapper){
        this.horrStDetailRepository = horrStDetailRepository;
        this.horrStDetailMapper = horrStDetailMapper;
    }

    /**
     * 무서운이야기 상세페이지 데이터 조회
     * @param horrStNo
     * @return
     */
    public HorrStDTO findDetail(String horrStNo){
        //Optional<HorrStEntity> story = horrStDetailRepository.findById(horrStNo);
        HorrStDTO story = horrStDetailMapper.findDetail(horrStNo);

        if(story == null) story = new HorrStDTO();

        return story;
    }

    /**
     * story를 삭제한다.(삭제 flag update)
     * @param horrStNo
     */
   public void deleteStory(String horrStNo){
       horrStDetailRepository.deleteStory(horrStNo);
   }

    /**
     * 조회수 증가시킨다
     * @param horrStNo
     */
   public void addViewCount(String horrStNo){
       horrStDetailRepository.addViewCount(horrStNo);
   }
}
