package com.xun.playground.common.config;

import com.xun.playground.horr.story.repository.HorrStDetailRepository;
import com.xun.playground.horr.story.repository.HorrStListRepository;
import com.xun.playground.horr.story.repository.JpaHorrStDetailRepository;
import com.xun.playground.horr.story.repository.JpaHorrStListRepository;
import com.xun.playground.horr.story.service.HorrStDetailService;
import com.xun.playground.horr.story.service.HorrStListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * Spring 설정
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

}
