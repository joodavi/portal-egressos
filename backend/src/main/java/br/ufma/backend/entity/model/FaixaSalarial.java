package br.ufma.backend.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    // todo relacionamentos
}
