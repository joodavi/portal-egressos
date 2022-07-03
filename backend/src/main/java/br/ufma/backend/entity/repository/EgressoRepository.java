package br.ufma.backend.entity.repository;

import br.ufma.backend.entity.model.Egresso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EgressoRepository extends JpaRepository <Egresso, Long> {
}
