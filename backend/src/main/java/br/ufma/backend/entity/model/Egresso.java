package br.ufma.backend.entity.model;

import lombok.*;

import java.util.List;

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

    // relationships

    @OneToMany(mappedBy = "egresso")
    private List<ProfissaoEgresso> profissaoEgressos;
    
    @ManyToMany
    @JoinTable(
        name = "contato_egresso", 
        joinColumns = @JoinColumn(name = "egresso_id"), 
        inverseJoinColumns = @JoinColumn(name = "contato_id"))
    private List<Contato> contatos;

    @OneToMany(mappedBy = "egresso")
    List<CursoEgresso> egressoCursos;

    @OneToMany(mappedBy = "egresso")
    private List<Depoimento> depoimentos;
}
