package br.ufma.backend.entity.repository;

import br.ufma.backend.entity.model.Curso;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    Optional<Curso> findByName(String name);
}
