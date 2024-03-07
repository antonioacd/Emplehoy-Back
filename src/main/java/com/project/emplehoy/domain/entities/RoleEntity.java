package com.project.emplehoy.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles", schema = "public", catalog = "EMPLEHOY")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role", nullable = false)
    private String role;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return ((RoleEntity) o).id.equals(this.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
