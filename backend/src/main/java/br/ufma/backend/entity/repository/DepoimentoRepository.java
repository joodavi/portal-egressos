package br.ufma.backend.entity.repository;

import br.ufma.backend.entity.model.Depoimento;
import br.ufma.backend.entity.model.Egresso;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepoimentoRepository extends JpaRepository <Depoimento, Long> {
    Optional<Depoimento> findByEgresso(Egresso egresso); 
}
