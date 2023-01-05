package com.xun.playground.horr.story.repository;

import com.xun.playground.horr.story.service.HorrStDetailService;
import com.xun.playground.horr.story.service.HorrStListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * 무서운이야기 서비스 스프링 통합테스트
 */
@SpringBootTest
@Transactional
public class HorrStIntTest {
    // 목록 서비스
    @Autowired
    HorrStListService listService;
    // 상세 서비스
    @Autowired
    HorrStDetailService detailService;


}
