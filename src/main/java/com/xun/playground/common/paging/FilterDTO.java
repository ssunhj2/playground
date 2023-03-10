package com.xun.playground.common.paging;

import lombok.Getter;
import lombok.Setter;

/**
 * 페이징을 위한 param
 */
@Getter
@Setter
public class FilterDTO {
    // 현재 페이지 번호
    private int page;
    // 페이지당 출력할 데이터 개수
    private int pageCount;
    // 하단에 표시할 페이지 개수
    private int pageSize;

    // 검색어
    private String searchText;
    // 검색 종류
    private String searchType;

    private Pagination pagination;

}
