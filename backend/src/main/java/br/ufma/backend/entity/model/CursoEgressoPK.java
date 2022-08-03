package br.ufma.backend.entity.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CursoEgressoPK implements Serializable {
    @Column(name = "curso_id")
    Long curso_id;

    @Column(name = "egresso_id")
    Long egresso_id;
}
