package org.plateer.backlms.rolling.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.plateer.backlms.reply.domain.QReply;
import org.plateer.backlms.rolling.domain.QRolling;
import org.plateer.backlms.rolling.domain.Rolling;
import org.plateer.backlms.rolling.dto.RollingReplyCountDTO;
import org.plateer.backlms.rolling.dto.RollingSearchDTO;
import org.plateer.backlms.rolling.dto.RollingSearchType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Log4j2
public class RollingSearchImpl extends QuerydslRepositorySupport implements RollingSearch {
    public RollingSearchImpl() {
        super(Rolling.class);
    }

    @Override
    public Page<RollingReplyCountDTO> searchList(Pageable pageable, RollingSearchDTO searchDTO) {
        QRolling rolling = QRolling.rolling;
        QReply reply = QReply.reply;

        JPQLQuery<Rolling> query = from(rolling);
        query.leftJoin(reply).on(rolling.eq(reply.rolling)).groupBy(rolling);

        BooleanBuilder builder = new BooleanBuilder();
        if (searchDTO.getSearchType() != null && searchDTO.getSearchValue() != null) {
            String keyword = searchDTO.getSearchValue();
            RollingSearchType searchType = searchDTO.getSearchType();

            if (RollingSearchType.TITLE.equals(searchType)) {
                builder.and(rolling.title.contains(keyword));
            } else if (RollingSearchType.TARGET.equals(searchType)) {
                builder.and(rolling.target.contains(keyword));
            }
        }

        query.where(builder);
        query.orderBy(rolling.id.desc());
        getQuerydsl().applyPagination(pageable, query);

        JPQLQuery<RollingReplyCountDTO> projectJPQLQuery = query.select(Projections.bean(
                RollingReplyCountDTO.class,
                rolling.id,
                rolling.title,
                rolling.writer.id.as("writerId"),
                rolling.target,
                rolling.imgSrc,
                reply.countDistinct().as("replyCount"),
                rolling.createDt,
                rolling.updateDt
        ));

        List<RollingReplyCountDTO> dtoList = projectJPQLQuery.fetch();
        long count = projectJPQLQuery.fetchCount();

        return new PageImpl<>(dtoList, pageable, count);
    }
}