package com.xun.playground.horr.story.repository;


import com.xun.playground.horr.story.domain.HorrStDomain;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * 무서운이야기 목록 JPA Repository
 */
public class JpaHorrStListRepository implements HorrStListRepository {

    private final EntityManager em;

    public JpaHorrStListRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public List<HorrStDomain> findHorrorStoryList() {
        return em.createQuery("SELECT s FROM HorrStDomain s", HorrStDomain.class).getResultList();
    }
}
