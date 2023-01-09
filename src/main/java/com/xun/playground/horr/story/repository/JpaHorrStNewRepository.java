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

    /**
     * 글을 수정한다.
     * @param story
     * @return
     */
    @Override
    public HorrStDomain modifyStory(HorrStDomain story) {
        String title = story.getTitle();
        String content = story.getContent();

        StringBuffer query = new StringBuffer();
        query.append("UPDATE HORROR_STORY SET ");
        if(title != null) query.append("   TITLE = :title ");
        if(content != null) query.append(" CONTENT = :content ");
        query.append(" WHERE HORR_ST_NO = :horrStNo");


        return null;
    }
}
