package com.burak.commentapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFindAllResponseDto {

    private String name;
    private String surName;
    private String telephone;
    private List<Long> favProducts;


}
