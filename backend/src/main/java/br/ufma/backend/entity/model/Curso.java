package br.ufma.backend.entity.model;

import lombok.*;

import java.util.List;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="curso")
@Builder
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "nivel")
    private String level;

    // relationships

    @OneToMany(mappedBy = "curso")
    List<Egresso> egressos;
}
