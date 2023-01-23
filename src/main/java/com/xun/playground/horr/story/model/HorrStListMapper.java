package com.xun.playground.horr.story.model;

import com.xun.playground.common.paging.FilterDTO;
import com.xun.playground.horr.story.dto.HorrStDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 무서운이야기 목록 mapper 인터페이스
 */
@Mapper
public interface HorrStListMapper {
    // 전체 글 count 조회
    int totalCnt(final FilterDTO pagingDTO);

    // 글 전체조회
    List<HorrStDTO> findAll(final FilterDTO pagingDTO);

}
