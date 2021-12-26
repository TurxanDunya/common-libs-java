package com.gamingbaku.user.repository;

import com.gamingbaku.user.domain.request.CreateNewsRequest;
import com.gamingbaku.user.domain.response.CreateNewsResponse;
import com.gamingbaku.user.dto.request.CreateNewsRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class NewsRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CreateNewsResponse create(CreateNewsRequest request) {

    }

    public CreateNewsRequestDto findById(Long id) {
//        jdbcTemplate.queryForObject();
        return new CreateNewsRequestDto();
    }

}