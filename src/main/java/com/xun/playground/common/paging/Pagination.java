package com.xun.playground.common.paging;

import lombok.Getter;

/**
 *
 */
@Getter
public class Pagination {
    // 전체 데이터 수
    private int totalCnt;
    // 전체 페이지 수
    private int totalPageCnt;
    // 첫 페이지 No
    private int startPage;
    // 끝 페이지 No
    private int endPage;
    // limit 시작위치
    private int limitStart;
    // 이전페이지 존재여부
    private boolean existPrevPage;
    // 이전페이지 존재여부
    private boolean existNextPage;

    public Pagination(int totalCnt, FilterDTO pagingDTO){
        if(totalCnt > 0){
            this.totalCnt = totalCnt;
            this.calculation(pagingDTO);
        }
    }

    // 페이지 계산
    private void calculation(FilterDTO pagingDTO){
        // 전체 페이지 수 계산
        totalPageCnt = ((totalCnt -1) / pagingDTO.getPageCount()) + 1;

        // 현재페이지 번호가 전체페이지 수 보다 큰 경우, 현재페이지 번호에 전체페이지 수 저장
        if(pagingDTO.getPage() > totalPageCnt){
            pagingDTO.setPage(totalPageCnt);
        }
        
        // 첫 페이지번호 계산
        startPage = ((pagingDTO.getPage()-1) / pagingDTO.getPageSize()) * pagingDTO.getPageSize() + 1;
        
        // 끝 페이지번호 계산
        endPage = startPage + pagingDTO.getPageSize() - 1;
        
        // 끝 페이지가 전체 페이지 수 보다 큰 경우, 끝페이지에 전체페이지 수 저장
        if(endPage > totalPageCnt){
            endPage = totalPageCnt;
        }
        
        // limit 시작 위치 계산
        limitStart = (pagingDTO.getPage() - 1) * pagingDTO.getPageCount();
        // 이전 페이지 존재여부
        existPrevPage = (startPage != 1);
        // 다음 페이지 존재여부
        existNextPage = (endPage * pagingDTO.getPageCount()) < totalCnt;
        
    }

}
