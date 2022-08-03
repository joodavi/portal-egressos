package br.ufma.backend.entity.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="prof_egresso")
@Builder
@Data
public class ProfissaoEgresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prof_egresso")
    private Long id;

    @Column(name = "empresa")
    private String company;

    @Column(name = "descricao")
    private String description;

    @Column(name = "data_registro")
    private Date date;

    // relationships

    @ManyToOne
    @JoinColumn(name = "egresso_id")
    private Egresso egresso;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "faixa_salario_id")
    private FaixaSalarial faixaSalarial;
}
