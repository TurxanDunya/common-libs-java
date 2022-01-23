package com.projecthope.news.repository;

import com.projecthope.news.domain.News;
import com.projecthope.news.repository.query.Queries;
import com.projecthope.news.repository.query.QueryHolder;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NewsRepository {

    private final QueryHolder queryHolder;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public NewsRepository(NamedParameterJdbcTemplate jdbcTemplate,
                          QueryHolder queryHolder) {
        this.jdbcTemplate = jdbcTemplate;
        this.queryHolder = queryHolder;
    }

    //     TODO add @Transactional
    public Long create(News news) {
        Map<String, Object> params = new HashMap<>();
        params.put("header", news.getHeader());
        params.put("body", news.getBody());
        params.put("type", news.getType());
        params.put("pictureKey", news.getPictureKey());
        params.put("lastModified", news.getLastModified());

        jdbcTemplate.update(queryHolder.get(Queries.CREATE_NEWS), params);

        return jdbcTemplate.queryForObject(
                queryHolder.get(Queries.FIND_LAST_ADDED),
                new HashMap<>(),
                new BeanPropertyRowMapper<>(Long.class));
    }

    public News findById(Long id) {
        var params = Map.of("id", id);

        return jdbcTemplate.queryForObject(
                queryHolder.get(Queries.FIND_BY_ID),
                params,
                new BeanPropertyRowMapper<>(News.class));
    }

    public List<News> findAll(String query) {
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(News.class));
    }

}