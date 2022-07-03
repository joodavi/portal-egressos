package br.ufma.backend.entity.repository;

import br.ufma.backend.entity.model.ProfissaoEgresso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissaoEgressoRepository extends JpaRepository <ProfissaoEgresso, Long> {
}
