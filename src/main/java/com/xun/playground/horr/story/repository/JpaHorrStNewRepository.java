package com.xun.playground.horr.story.repository;

import com.xun.playground.horr.story.domain.HorrStDomain;

import javax.persistence.EntityManager;

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
}
