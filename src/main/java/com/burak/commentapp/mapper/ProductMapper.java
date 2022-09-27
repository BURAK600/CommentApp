package com.burak.commentapp.mapper;

import com.burak.commentapp.dto.response.ProductCreateResponseDto;
import com.burak.commentapp.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductCreateResponseDto toProductCreateResponseDto(final Product product);
}
