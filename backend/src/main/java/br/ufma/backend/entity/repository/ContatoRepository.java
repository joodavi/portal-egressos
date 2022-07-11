package br.ufma.backend.entity.repository;

import br.ufma.backend.entity.model.Contato;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository <Contato, Long> {
    Optional<Contato> findByName(String name);
}
