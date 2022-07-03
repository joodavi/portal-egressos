package br.ufma.backend.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    // todo relacionamentos
}
