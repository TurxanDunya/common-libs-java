package com.gamingbaku.user.mapper;

import com.gamingbaku.user.domain.response.CreateNewsResponse;
import com.gamingbaku.user.dto.response.CreateNewsResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NewsMapper {

    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    CreateNewsResponseDto toCreateNewsResponseDto(CreateNewsResponse response);

}