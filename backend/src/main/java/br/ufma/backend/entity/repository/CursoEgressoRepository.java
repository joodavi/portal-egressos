package br.ufma.backend.entity.repository;

import br.ufma.backend.entity.model.CursoEgresso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoEgressoRepository extends JpaRepository <CursoEgresso, Long> {
}
