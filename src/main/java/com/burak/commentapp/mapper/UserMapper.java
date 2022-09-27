package com.burak.commentapp.mapper;

import com.burak.commentapp.dto.response.UserCreateResponseDto;
import com.burak.commentapp.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserCreateResponseDto toUserCreateResponseDto(final User user);

    User toUser(final UserCreateResponseDto userCreateResponseDto);
}
