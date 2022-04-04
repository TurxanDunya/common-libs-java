package com.projecthope.news.service;

import com.projecthope.news.config.properties.NewsProperties;
import com.projecthope.news.domain.News;
import com.projecthope.news.dto.request.CreateNewsRequestDto;
import com.projecthope.news.dto.request.NewsFilter;
import com.projecthope.news.dto.response.CreateNewsResponseDto;
import com.projecthope.news.dto.response.NewsDto;
import com.projecthope.news.dto.response.NewsResponseDto;
import com.projecthope.news.error.ErrorCodes;
import com.projecthope.news.error.ServiceException;
import com.projecthope.news.mapper.NewsMapper;
import com.projecthope.news.repository.NewsRepository;
import com.projecthope.news.repository.query.Queries;
import com.projecthope.news.repository.query.QueryHolder;
import com.projecthope.news.repository.query.QueryPart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;
    private final NewsProperties newsProperties;
    private final QueryHolder queryHolder;

    public NewsService(NewsRepository newsRepository,
                       NewsMapper newsMapper,
                       NewsProperties newsProperties,
                       QueryHolder queryHolder) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
        this.newsProperties = newsProperties;
        this.queryHolder = queryHolder;
    }

    public CreateNewsResponseDto create(CreateNewsRequestDto requestDto) {
        log.info("Requested for creating news: {}", requestDto);
        News news = newsMapper.toNews(requestDto);
        // TODO: pass picture object to ms-content and get object key in future

        Long lastAddedNewsId = newsRepository.create(news);
        log.info("News created successfully: {}", lastAddedNewsId);
        return new CreateNewsResponseDto(lastAddedNewsId);
    }

    public NewsDto findById(Long id) {
        return newsRepository.findById(id).stream()
                .findFirst()
                .map(newsMapper::toNewsDto)
                .orElseThrow(() -> ServiceException.of(
                        ErrorCodes.NEWS_NOT_FOUND, "News not found for given id: " + id));
    }

    public NewsResponseDto findAll(NewsFilter filter) {
        Integer limit = Objects.nonNull(filter.getLimit()) ?
                filter.getLimit() : newsProperties.getInitialLimit();

        if (limit > newsProperties.getMaxLimit())
            throw new RuntimeException("Max Limit Exceeded");

        Integer offset = Objects.nonNull(filter.getOffset()) ?
                filter.getOffset() : newsProperties.getDefaultOffset();

        filter.setLimit(limit + 1); // Get one more row for simulate has next
        filter.setOffset(offset);

        final StringBuilder queryFilterPart = new StringBuilder();
        QueryPart.applyNewsTypeFilter(filter, queryFilterPart);

        String query = queryHolder.get(Queries.FIND_ALL)
                .replaceAll(QueryPart.QUERY_FILTER_PART_KEY, queryFilterPart.toString());
        String queryValue = QueryPart.applyPaging(filter, query);

        List<News> news = newsRepository.findAll(queryValue);

        boolean hasNext = news.size() == filter.getLimit();
        if (hasNext)
            news.remove(filter.getLimit() - 1);

        List<NewsDto> newsDtoList = newsMapper.toNewsDtoList(news);
        return new NewsResponseDto(hasNext, newsDtoList);
    }

}