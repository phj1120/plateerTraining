package today.parkh.v0115.common.domain.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageReqDTO {
    private int page;

    private int pageSize;

    private String key;
    public PageReqDTO() {
        this.page = 1;
        this.pageSize = 10;
    }

    public PageReqDTO(int page, int pageSize) {
        setPage(page);
        setSize(pageSize);
    }

    public void setPage(int page) {
        this.page = Math.max(page, 1);
    }

    public void setSize(int size) {
        //10 <= size <= 100
        this.pageSize = Math.max(10, Math.min(size, 100));
    }

    public Pageable getPageable(Sort sort) {
        Pageable pageable = PageRequest.of(this.page - 1, this.pageSize, sort);
        return pageable;
    }
}
