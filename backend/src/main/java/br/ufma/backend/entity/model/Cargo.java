package br.ufma.backend.entity.model;

import lombok.*;

import java.util.List;

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

    // relationships

    @OneToMany(mappedBy = "cargo")
    private List<ProfissaoEgresso> profissaoEgressos;
}
