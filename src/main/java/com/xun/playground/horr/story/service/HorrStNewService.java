package com.xun.playground.horr.story.service;


import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.form.HorrStForm;
import com.xun.playground.horr.story.repository.HorrStNewRepository;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 * 무서운이야기 게시판 글쓰기 service
 */
@Transactional
public class HorrStNewService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final HorrStNewRepository horrStNewRepository;

    @Autowired
    public HorrStNewService(HorrStNewRepository horrStNewRepository){
        this.horrStNewRepository = horrStNewRepository;
    }

    /**
     * 무서운이야기 글 저장
     * @param form
     * @return
     */
    public HorrStDomain saveStory(HorrStForm form){
        String horrStNo = form.getHorrStNo();

        HorrStDomain story = new HorrStDomain();
        story.setEnterBy(form.getEnterBy());
        story.setTitle(form.getTitle());
        story.setContent(form.getContent());

        // 수정
        if(!StringUtils.isEmpty(horrStNo)){
            return horrStNewRepository.modifyStory(story);
        }

        // 입력
        return horrStNewRepository.createStory(story);
    }

}
