package org.parkh.b1.common.domain.dto;

import lombok.Data;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Data
public class PageResultDTO<E> {

    private List<E> dtoList;

    //현재페이지
    private int pageNum;

    //전체페이지
    private long totalPageNum, totalCount;

    private int pageSize;

    //시작, 끝 페이지
    private int start, end;

    public PageResultDTO(List<E> dtoList, Pageable pageable, long total, long totalPage) {

        this.dtoList = dtoList;

        this.pageNum = pageable.getPageNumber() + 1;
        this.pageSize = pageable.getPageSize();

        this.totalCount = total;
        this.totalPageNum = totalPage;

        this.start = (int) ((Math.ceil(this.pageNum / 10.0) * 10)) - 9;
        int tempEnd = (int) ((Math.ceil(this.pageNum / 10.0) * 10));

        this.end = tempEnd * pageSize > totalCount ? (int) Math.ceil(totalCount / (double) pageSize) : tempEnd;
    }
}
