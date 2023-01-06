package com.xun.playground.common.config;

import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.repository.*;
import com.xun.playground.horr.story.service.HorrStDetailService;
import com.xun.playground.horr.story.service.HorrStListService;
import com.xun.playground.horr.story.service.HorrStNewService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * Spring 설정
 * 임시 Repository를 사용하다가 추후 DB로 변경할때 수정을 적게 하기위해
 * 설정페이지를 만듦.
 */
@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private  final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em){
        this.dataSource = dataSource;
        this.em = em;
    }

    // 무서운이야기 목록 서비스
    @Bean
    public HorrStListService horrStListService(){
        return new HorrStListService(horrStListRepository());
    }

    // 무서운이야기 목록 JPA Repository
    @Bean
    public HorrStListRepository horrStListRepository(){
        return new JpaHorrStListRepository(em);
    }

    // 무서운이야기 상세 서비스
    @Bean
    public HorrStDetailService horrStDetailService(){
        return new HorrStDetailService(horrStDetailRepository());
    }

    // 무서운이야기 상세 JPA Repository
    @Bean
    public HorrStDetailRepository horrStDetailRepository(){
        return new JpaHorrStDetailRepository(em);
    }

    @Bean
    public HorrStNewService horrStNewService(){
        return new HorrStNewService(horrStNewRepository());
    }

    @Bean
    public HorrStNewRepository horrStNewRepository(){
        return new JpaHorrStNewRepository(em);
    }

}
