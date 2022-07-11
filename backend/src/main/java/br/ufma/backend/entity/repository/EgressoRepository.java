package br.ufma.backend.entity.repository;

import br.ufma.backend.entity.model.Egresso;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EgressoRepository extends JpaRepository <Egresso, Long> {
    Optional<Egresso> findByName(String name);
    Optional<Egresso> findByEmail(String name);
    Optional<Egresso> findByCpf(String name);
}
