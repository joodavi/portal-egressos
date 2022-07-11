package br.ufma.backend.repository;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.ufma.backend.entity.model.Cargo;
import br.ufma.backend.entity.repository.CargoRepository;

public class CargoRepositoryTest {
    @Autowired
    CargoRepository repository;

    @Test
    public void shouldSaveCargo() {
        Cargo newCargo = Cargo.builder().name("name").description("description").build();

        Cargo saved = repository.save(newCargo);

        Assertions.assertNotNull(saved);
        Assertions.assertEquals(newCargo.getName(), saved.getName());
        Assertions.assertEquals(newCargo.getDescription(), saved.getDescription());
    }

    @Test
    public void shouldDeleteCargo() {
        Cargo newCargo = Cargo.builder().name("name").description("description").build();

        Cargo saved = repository.save(newCargo);

        repository.deleteById(saved.getId());

        Optional<Cargo> testDelete = repository.findById(saved.getId());
        Assertions.assertTrue(testDelete.isEmpty());
    }

    @Test
    public void shouldUpdateCargo() {
        Cargo newCargo = Cargo.builder().name("name").description("description").build();

        Cargo saved = repository.save(newCargo);

        saved.setName("new name");
        saved.setDescription("description");

        Cargo updateCargo = repository.save(saved);

        Assertions.assertNotNull(updateCargo);
        Assertions.assertEquals(saved.getName(), updateCargo.getName());
        Assertions.assertEquals(saved.getDescription(), updateCargo.getDescription());
    }

    @Test
    public void shouldFindCargoByName() {
        Cargo newCargo = Cargo.builder().name("name").description("description").build();

        Cargo saved = repository.save(newCargo);

        Optional<Cargo> testFind = repository.findByName(saved.getName());
        Cargo testFindEquals = testFind.get();

        Assertions.assertFalse(testFind.isEmpty());
        Assertions.assertEquals(saved.getId(), testFindEquals.getId());
        Assertions.assertEquals(saved.getName(), testFindEquals.getName());
        Assertions.assertEquals(saved.getDescription(), testFindEquals.getDescription());
    }
}
