package br.ufma.backend.entity.model;

import lombok.*;

import java.util.List;

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

    // relationships

    @ManyToMany(mappedBy = "contatos")
    private List<Egresso> egressos;
}
