package br.ufma.backend.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

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
