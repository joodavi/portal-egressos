package br.ufma.backend.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cargo")
@Builder
@Data
public class CursoEgresso {
    @EmbeddedId
    CursoEgressoPK id;

    @Column(name = "data_conclusao")
    Date date;

    // todo relacionamentos
}
