package today.parkh.v0115.common.domain.dto;

import org.springframework.data.domain.Pageable;

import java.util.List;

public class PageResultDTO<E> {
    private List<E> dtoList;

    private long pageNum;

    private long totalPageNum, totalCount;

    private long pageSize;
    private long start, end;

    public PageResultDTO(List<E> dtoList, Pageable pageable, long totalCount, long totalPageNum) {
        this.dtoList = dtoList;
        this.pageNum = pageable.getPageNumber();
        this.pageSize = pageable.getPageSize();
        this.totalCount = totalCount;
        this.totalPageNum = totalPageNum;

        this.start = (long) (Math.ceil(this.pageNum / 10.0)) - 9;
        this.end = Math.min((long) (Math.ceil(this.pageNum / 10.0)), (long) Math.ceil(totalCount / (double) pageSize));
    }
}
