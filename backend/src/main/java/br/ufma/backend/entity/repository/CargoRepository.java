package br.ufma.backend.entity.repository;

import br.ufma.backend.entity.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository <Cargo, Long> {
}
