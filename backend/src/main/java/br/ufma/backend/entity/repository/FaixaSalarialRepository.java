package br.ufma.backend.entity.repository;

import br.ufma.backend.entity.model.FaixaSalarial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaixaSalarialRepository extends JpaRepository <FaixaSalarial, Long> {
}
