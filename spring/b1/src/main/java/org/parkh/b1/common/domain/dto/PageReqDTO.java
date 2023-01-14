package org.parkh.b1.common.domain.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageReqDTO {
    private int page;

    private int pageSize;

    public PageReqDTO() {
        this.page = 1;
        this.pageSize = 10;
    }

    public PageReqDTO(int page, int pageSize) {
        setPage(page);
        setSize(pageSize);
    }


    public void setPage(int page) {
        this.page = page <= 0 ? 1 : page;
    }

    public void setSize(int size) {
        //10 <= size <= 100
        this.pageSize = size <= 10 ? 10 : size >= 100 ? 50 : size;
    }

    public Pageable getPageable(Sort sort) {
        Pageable pageable = PageRequest.of(this.page - 1, this.pageSize, sort);
        return pageable;
    }


}
