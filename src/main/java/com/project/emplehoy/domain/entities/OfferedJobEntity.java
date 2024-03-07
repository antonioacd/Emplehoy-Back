package com.project.emplehoy.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "offered_jobs", schema = "public", catalog = "EMPLEHOY")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferedJobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "offered_user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "offered_job_id", referencedColumnName = "id", nullable = false)
    private JobEntity job;

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        return ((OfferedJobEntity) o).id.equals(this.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
