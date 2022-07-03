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
@Table(name="curso")
@Builder
@Data
public class Depoimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_depoimento")
    private Long id;

    @Column(name="texto")
    private String text;

    @Column(name="data")
    private Date date;

    // todo relacionamentos
}
