package com.xun.playground.common.config;


import org.springframework.context.annotation.Configuration;



/**
 * Spring 설정
 * 임시 Repository를 사용하다가 추후 DB로 변경할때 수정을 적게 하기위해
 * 설정페이지를 만듦.
 */
@Configuration
public class SpringConfig {


    //private final DataSource dataSource;
    /*private  final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em){
        this.dataSource = dataSource;
        this.em = em;
    }*/

    // 무서운이야기 목록 서비스
    /*@Bean
    public HorrStListService horrStListService(){
        return new HorrStListService(horrStListRepository());
    }

    // 무서운이야기 목록 JPA Repository
    @Bean
    public HorrStListRepository horrStListRepository(){
        return (HorrStListRepository) new JpaHorrStListRepository();
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
        return new HorrStNewService(new HorrStNewRepository());
    }

    @Bean
    public HorrStDetailRepository horrStDetailRepository(){
        return new JpaHorrStDetailRepository(em);
    }*/

}
