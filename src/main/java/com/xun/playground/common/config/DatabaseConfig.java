package com.xun.playground.common.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Database Config
 */
@Configuration
@PropertySource("classpath:/application.properties")
@RequiredArgsConstructor
public class DatabaseConfig {

    @Autowired
    private ApplicationContext context; // 스프링 컨테이너 중 하나

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig(){
        return new HikariConfig(); // 커넥션풀 라이브러리
    }

    @Bean
    public DataSource dataSource(){
        return new HikariDataSource(hikariConfig()); // 커넥션풀을 지원하는 인터페이스
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws  Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean(); // mybatis, spring 연동모듈
        factoryBean.setDataSource(dataSource());

        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory()); // SQL 실행에 필요한 메서드를 갖는 객체
    }

}
