package com.xun.playground.horr.story.repository;


import com.xun.playground.horr.story.domain.HorrStDomain;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * 무서운이야기 상세 JPA Repository
 */
public class JpaHorrStDetailRepository implements HorrStDetailRepository {

    private final EntityManager em;

    public JpaHorrStDetailRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Optional<HorrStDomain> findHorrorStoryDetail(String horrStNo) {
        List<HorrStDomain> story = em.createQuery("SELECT s FROM HorrStDomain s WHERE s.horrStNo = :horrStNo", HorrStDomain.class)
                .setParameter("horrStNo", horrStNo)
                .getResultList();
        return story.stream().findAny();
    }
}
