package com.projecthope.news.repository;

import com.projecthope.news.domain.News;
import com.projecthope.news.repository.query.Queries;
import com.projecthope.news.repository.query.QueryHolder;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class NewsRepository {

    private final QueryHolder queryHolder;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public NewsRepository(NamedParameterJdbcTemplate jdbcTemplate,
                          QueryHolder queryHolder) {
        this.jdbcTemplate = jdbcTemplate;
        this.queryHolder = queryHolder;
    }

    @Transactional
    public Long create(News news) {
        Map<String, Object> params = new HashMap<>();
        params.put("header", news.getHeader());
        params.put("body", news.getBody());
        params.put("type", news.getType());
        params.put("lastModified", news.getLastModified());
        params.put("pictureKey", news.getPictureKey());

        jdbcTemplate.update(queryHolder.get(Queries.CREATE), params);

        return jdbcTemplate.queryForObject(
                queryHolder.get(Queries.FIND_LAST_ADDED), new HashMap<>(), Long.class);
    }

    public Optional<News> findById(Long id) {
        List<News> news = jdbcTemplate.query(
                queryHolder.get(Queries.FIND_BY_ID),
                Map.of("id", id),
                new BeanPropertyRowMapper<>(News.class));

        return news.stream().findFirst();
    }

    public List<News> findAll(String query) {
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(News.class));
    }

}