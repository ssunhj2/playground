package com.xun.playground.horr.story.service;

import com.xun.playground.horr.story.domain.HorrStDomain;
import com.xun.playground.horr.story.dto.HorrStDTO;
import com.xun.playground.horr.story.repository.HorrStListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 무서운이야기 콘텐츠 서비스
 */
@Transactional
@Service
public class HorrStListService {
    private final HorrStListRepository horrStListRepository;

    @Autowired
    public HorrStListService(HorrStListRepository horrStListRepository){
        this.horrStListRepository = horrStListRepository;
    }


    /**
     * 무서운이야기 전체 컨텐츠 조회
     */
    public List<HorrStDTO> findAllList(){
        Sort sort = Sort.by(Sort.Direction.DESC, "enterDate");
        List<HorrStDomain> resultList = horrStListRepository.findAll(sort);
        return resultList.stream().map(HorrStDTO::new).collect(Collectors.toList());
    }
}
