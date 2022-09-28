package com.burak.commentapp.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCommentCreateResponseDto {

    private String comment;
    private Long productId;
    private Long userId;
}
