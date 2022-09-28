package com.burak.commentapp.mapper;


import com.burak.commentapp.dto.request.ProductCommentCreateRequestDto;
import com.burak.commentapp.dto.response.ProductCommentCreateResponseDto;
import com.burak.commentapp.repository.entity.ProductComment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCommentMapper {

    ProductCommentMapper INSTANCE = Mappers.getMapper(ProductCommentMapper.class);

    ProductComment toProductComment(final ProductCommentCreateRequestDto productCommentCreateRequestDto);

    ProductCommentCreateResponseDto toProductCommentCreateResponseDto( final ProductCommentCreateRequestDto productCommentCreateRequestDto);

}
