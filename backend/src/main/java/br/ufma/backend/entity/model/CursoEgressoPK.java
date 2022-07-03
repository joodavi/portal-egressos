package br.ufma.backend.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
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
