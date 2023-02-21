package com.xun.playground.horr.story.model;

import com.xun.playground.horr.story.dto.HorrStDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 무서운이야기 상세페이지 mapper 인터페이스
 */
@Mapper
public interface HorrStDetailMapper {
    // 번호로 상세페이지 조회
    HorrStDTO findDetail(String horrStNo);
}
