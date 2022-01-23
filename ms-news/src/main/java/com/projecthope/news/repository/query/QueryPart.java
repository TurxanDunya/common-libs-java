package com.projecthope.news.repository.query;

import com.projecthope.news.dto.NewsType;
import com.projecthope.news.dto.request.NewsFilter;

public final class QueryPart {

    public static final String QUERY_FILTER_PART_KEY = "\\{QUERY_FILTER_PART\\}";

    public static void applyNewsTypeFilter(NewsFilter filter, StringBuilder queryFilterPart) {
        if (filter.getType() == NewsType.GAME) {
            String queryPart = " (pr.prefix LIKE '5%' OR pr.prefix LIKE '6%') ";
            queryFilterPart.append(queryPart);
        }

        if (filter.getType() == NewsType.FILM) {

        }

        if (filter.getType() == NewsType.TECHNO) {

        }

        if (filter.getType() == NewsType.OTHER) {

        }

        if (filter.getType() == NewsType.ALL) {

        }
    }

    public static String applyPaging(NewsFilter filter, String query) {
        String queryPart = String.format(" OFFSET %d ROWS FETCH FIRST %d ROWS ONLY",
                filter.getOffset(),
                filter.getLimit());

        return query.concat(queryPart);
    }

    private QueryPart() {
    }

}