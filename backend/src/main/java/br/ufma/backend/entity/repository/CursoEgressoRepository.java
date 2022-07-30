package br.ufma.backend.entity.repository;

import br.ufma.backend.entity.model.CursoEgresso;
import br.ufma.backend.entity.model.CursoEgressoPK;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoEgressoRepository extends JpaRepository <CursoEgresso, Long> {

    void deleteById(CursoEgressoPK id);

    Optional<CursoEgresso> findById(CursoEgressoPK id);
}
