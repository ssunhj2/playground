package com.xun.playground.horr.story.repository;

import com.xun.playground.common.CommonUtils;
import com.xun.playground.horr.story.domain.HorrStDomain;

import javax.persistence.EntityManager;
import java.time.LocalDate;

/**
 * 무서운이야기 글쓰기 JPA Repository
 */
public class JpaHorrStNewRepository implements HorrStNewRepository {

    private final EntityManager em;

    public JpaHorrStNewRepository(EntityManager em){
        this.em = em;
    }

    /**
     * 작성한 이야기를 저장한다.
     * @param story
     * @return
     */
    @Override
    public HorrStDomain createStory(HorrStDomain story) {
        em.persist(story);
        return story;
    }

    /**
     * 글을 수정한다.
     * @param story
     * @return
     */
    @Override
    public HorrStDomain modifyStory(HorrStDomain story) {
        String horrStNo = story.getHorrStNo();

        HorrStDomain modiStory = em.find(HorrStDomain.class, horrStNo);
        modiStory.setTitle(story.getTitle());
        modiStory.setContent(story.getContent());
        modiStory.setUpdateBy(story.getEnterBy());


        return modiStory;
    }
}
