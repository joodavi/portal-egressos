package br.ufma.backend.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="depoimento")
@Builder
@Data
public class Depoimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_depoimento")
    private Long id;

    @Column(name="texto")
    private String text;

    @Column(name="data")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="egresso_id")
    private Egresso egresso;

}
