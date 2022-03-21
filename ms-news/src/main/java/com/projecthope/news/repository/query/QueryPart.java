package com.projecthope.news.repository.query;

import com.projecthope.news.dto.request.NewsFilter;

import java.util.Objects;

public final class QueryPart {

    public static final String QUERY_FILTER_PART_KEY = "\\{QUERY_FILTER_PART\\}";

    public static void applyNewsTypeFilter(NewsFilter filter, StringBuilder queryFilterPart) {
        String queryPart = "";

        if (Objects.isNull(filter.getType())) {
            return;
        }

        switch (filter.getType()) {
            case GAME:
                queryPart = " WHERE type = 1 ";
                break;
            case FILM:
                queryPart = " WHERE type = 2 ";
                break;
            case TECHNO:
                queryPart = " WHERE type = 3 ";
                break;
            case OTHER:
                queryPart = " WHERE type = 4 ";
                break;
        }

        queryFilterPart.append(queryPart);
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