package br.ufma.backend.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="contato")
@Builder
@Data
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_contato")
    private Long id;

    @Column(name="nome")
    private String name;

    @Column(name="urlLogo")
    private String urlLogo;

    // todo relacionamentos
}
