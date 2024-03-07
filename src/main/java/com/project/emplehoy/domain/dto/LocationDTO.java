package com.project.emplehoy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {

    private Long id;
    private String country;
    private String region;
    private String city;
    private String street;
}
