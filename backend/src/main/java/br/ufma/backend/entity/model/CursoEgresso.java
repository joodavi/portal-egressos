package br.ufma.backend.entity.model;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="curso_egresso")
@Builder
@Data
public class CursoEgresso {
    @EmbeddedId
    CursoEgressoPK id;

    @Column(name = "data_inicio")
    LocalDate initialDate;

    @Column(name = "data_conclusao")
    LocalDate finishDate;

    // relationships

    @ManyToOne
    @MapsId("egresso_id")
    @JoinColumn(name = "egresso_id")
    Egresso egresso;

    @ManyToOne
    @MapsId("curso_id")
    @JoinColumn(name = "curso_id")
    Curso curso;
}
