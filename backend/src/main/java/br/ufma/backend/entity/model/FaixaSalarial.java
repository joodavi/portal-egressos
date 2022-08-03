package br.ufma.backend.entity.model;

import lombok.*;

import java.util.List;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="faixa_salario")
@Builder
@Data
public class FaixaSalarial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_faixa_salario")
    private Long id;

    @Column(name="descricao")
    private String description;

    // relationships

    @OneToMany(mappedBy = "faixaSalario")
    private List<ProfissaoEgresso> profissaoEgressos;
}
