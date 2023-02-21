package com.xun.playground.horr.story.service;


import com.xun.playground.horr.story.entity.HorrStEntity;
import com.xun.playground.horr.story.dto.HorrStDTO;
import com.xun.playground.horr.story.model.HorrStDetailMapper;
import com.xun.playground.horr.story.repository.HorrStNewRepository;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * 무서운이야기 게시판 글쓰기 service
 */
@Transactional
@Service
public class HorrStNewService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final HorrStNewRepository horrStNewRepository;
    private final HorrStDetailMapper horrStDetailMapper;

    @Autowired
    public HorrStNewService(HorrStNewRepository horrStNewRepository, HorrStDetailMapper horrStDetailMapper){
        this.horrStNewRepository = horrStNewRepository;
        this.horrStDetailMapper = horrStDetailMapper;
    }

    /**
     * 무서운이야기 글 저장
     * @param horrStDto
     * @return
     */
    public HorrStDTO saveStory(HorrStDTO horrStDto){
        String horrStNo = horrStDto.getHorrStNo();

        String title = horrStDto.getTitle();
        String content = horrStDto.getContent();
        String enterBy = horrStDto.getEnterBy();

        // 수정
        if(!StringUtils.isEmpty(horrStNo)){
            Optional<HorrStEntity> entity = horrStNewRepository.findById(horrStNo);

            if(entity.isPresent()){
                entity.get().update(title, content, enterBy);
            }
            return horrStDto;
        }

        HorrStEntity entity = new HorrStEntity("0", title, content, enterBy);
        HorrStEntity story = horrStNewRepository.save(entity);

        return new HorrStDTO(story);
    }

}
