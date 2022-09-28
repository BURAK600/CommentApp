package com.burak.commentapp.mapper;

import com.burak.commentapp.dto.request.LikeCreateRequestDto;
import com.burak.commentapp.repository.entity.Like;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LikeMapper {

    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    Like  toLike(final LikeCreateRequestDto likeCreateRequestDto);

}
