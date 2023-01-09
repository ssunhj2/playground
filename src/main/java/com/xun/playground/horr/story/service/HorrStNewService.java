package com.xun.playground.horr.story.service;

import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.form.HorrStForm;
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
     * @param form
     * @return
     */
    public HorrStDomain saveStory(HorrStForm form){
        String horrStNo = form.getHorrStNo();

        HorrStDomain story = new HorrStDomain();
        story.setEnterBy(form.getEnterBy());

        String title = nullToEmpty(form.getTitle());
        String content = nullToEmpty(form.getContent());

        // 수정
        if(horrStNo != null && !"".equals(horrStNo)){
            String oldTitle = nullToEmpty(form.getOldTitle());
            String oldContent = nullToEmpty(form.getOldContent());
            /**
             * 수정된 값만 저장한다.
             */
            if(!oldTitle.equals(title)) story.setTitle(title);
            if(!oldContent.equals(content)) story.setContent(content);

            return horrStNewRepository.modifyStory(story);
        }

        story.setTitle(title);
        story.setContent(content);

        // 입력
        return horrStNewRepository.createStory(story);
    }


    // null 값을 "" 로 변경하여 반환한다.
    private String nullToEmpty(String checkString){
        if(checkString == null) return "";

        return checkString;
    }


}
