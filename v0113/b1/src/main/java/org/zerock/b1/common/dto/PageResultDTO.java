package org.zerock.b1.common.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Data
public class PageResultDTO <E>{

    private List<E> dtoList;

    private int pageNum;

    private long totalPageNum, totalCount;

    private int pageSize;

    private int start, end;

    public PageResultDTO(List<E> dtoList, Pageable pageable, long total, long totalPage ){

        this.dtoList = dtoList;
        this.pageNum = pageable.getPageNumber() +1;
        this.totalPageNum = totalPage;
        this.totalCount = total;
        this.pageSize = pageable.getPageSize();


        this.start = (int) ((Math.ceil(this.pageNum / 10.0)) * 10 ) - 9;

        int tempEnd = (int)(((Math.ceil(this.pageNum / 10.0)) * 10 ));

        this.end = tempEnd* pageSize > totalCount ?
                (int)(Math.ceil(totalCount/(double)pageSize)) : tempEnd;

    }
}


















