package br.ufma.backend.entity.repository;

import br.ufma.backend.entity.model.Depoimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepoimentoRepository extends JpaRepository <Depoimento, Long> {
}
