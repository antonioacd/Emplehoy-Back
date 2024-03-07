package com.project.emplehoy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OpinionDTO {

    private Long id;
    private int rating;
    private String text;
    private UserDTO user;
}
