package com.project.emplehoy.domain.dto;

import com.project.emplehoy.domain.entities.LocationEntity;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String number;
    private int age;
    private String occupation;
    private String image;
    private String description;
    private int rating;
    private LocationEntity location;
    private List<RoleDTO> roles;
}
