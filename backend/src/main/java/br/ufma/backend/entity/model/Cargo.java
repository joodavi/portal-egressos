package br.ufma.backend.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cargo")
@Builder
@Data
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cargo")
    private Long id;

    @Column(name="nome")
    private String name;

    @Column(name="descricao")
    private String description;

    // todo relacionamentos
}
