package com.project.emplehoy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteJobDTO {

    private Long id;
    private UserDTO user;
    private JobDTO job;
}
