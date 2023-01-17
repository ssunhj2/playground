package com.xun.playground.horr.story.service;

import com.xun.playground.common.paging.Pagination;
import com.xun.playground.common.paging.PagingDTO;
import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.dto.HorrStDTO;
import com.xun.playground.horr.story.model.HorrStListMapper;
import com.xun.playground.horr.story.repository.HorrStListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 무서운이야기 콘텐츠 서비스
 */
@Transactional
@Service
public class HorrStListService {
    private final HorrStListRepository horrStListRepository;
    private final HorrStListMapper horrStListMapper; // mapper

    @Autowired
    public HorrStListService(HorrStListRepository horrStListRepository, HorrStListMapper horrStListMapper){
        this.horrStListRepository = horrStListRepository;
        this.horrStListMapper = horrStListMapper;
    }


    /**
     * 무서운이야기 전체 컨텐츠 조회
     */
    public List<HorrStDTO> findAllList(){
        Sort sort = Sort.by(Sort.Direction.DESC, "enterDate");
        List<HorrStDomain> resultList = horrStListRepository.findAll(sort);
        return resultList.stream().map(HorrStDTO::new).collect(Collectors.toList());
    }

    /**
     * 무서운이야기 전체 컨텐츠 조회: 페이징 적용
     * @param pagingDTO
     * @return
     */
    public Map<String, Object> findAll(PagingDTO pagingDTO){
        // 글 전체 count 조회
        int count = horrStListMapper.totalCnt(pagingDTO);

        if(count < 1){
            return Collections.emptyMap();
        }

        // pagination 정보 계산
        Pagination pagination = new Pagination(count, pagingDTO);
        pagingDTO.setPagination(pagination);

        // 글 전체조회
        List<HorrStDTO> list = horrStListMapper.findAll(pagingDTO);

        // 데이터 반환
        Map<String, Object> result = new HashMap<>();
        result.put("pagingDTO", pagingDTO);
        result.put("list", list);

        return result;
    }
}
