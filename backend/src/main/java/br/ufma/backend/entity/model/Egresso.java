package br.ufma.backend.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="egresso")
@Builder
@Data
public class Egresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_egresso")
    private Long id;

    @Column(name="nome")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="cpf")
    private String cpf;

    @Column(name="resumo")
    private String resume;

    @Column(name="urlFoto")
    private String urlPhoto;

    // todo relacionamentos
}
