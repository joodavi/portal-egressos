package br.ufma.backend.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.ufma.backend.entity.model.FaixaSalarial;
import br.ufma.backend.entity.repository.FaixaSalarialRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class FaixaSalarialTest {
    @Autowired
    FaixaSalarialRepository repository;

    @Test
    public void shouldSaveFaixaSalarial() {
        FaixaSalarial newFaixaSalarial = FaixaSalarial.builder().description("description").build();

        FaixaSalarial saved = repository.save(newFaixaSalarial);

        Assertions.assertNotNull(saved);
        Assertions.assertEquals(newFaixaSalarial.getDescription(), saved.getDescription());
    }

    @Test
    public void shouldDeleteFaixaSalarial() {
        FaixaSalarial newFaixaSalarial = FaixaSalarial.builder().description("description").build();

        FaixaSalarial saved = repository.save(newFaixaSalarial);

        repository.deleteById(saved.getId());

        Optional<FaixaSalarial> testDelete = repository.findById(saved.getId());
        Assertions.assertTrue(testDelete.isEmpty());
    }

    @Test
    public void shouldUpdateFaixaSalarial() {
        FaixaSalarial newFaixaSalarial = FaixaSalarial.builder().description("description").build();

        FaixaSalarial saved = repository.save(newFaixaSalarial);

        saved.setDescription("new description");

        FaixaSalarial updateFaixaSalarial = repository.save(saved);

        Assertions.assertNotNull(updateFaixaSalarial);
        Assertions.assertEquals(saved.getDescription(), updateFaixaSalarial.getDescription());
    }

    @Test
    public void shouldFindFaixaSalarialByDescricao() {
        FaixaSalarial newFaixaSalarial = FaixaSalarial.builder().description("description").build();

        FaixaSalarial saved = repository.save(newFaixaSalarial);

        Optional<FaixaSalarial> testFind = repository.findByDescription(saved.getDescription());
        FaixaSalarial testFindEquals = testFind.get();

        Assertions.assertFalse(testFind.isEmpty());
        Assertions.assertEquals(saved.getId(), testFindEquals.getId());
        Assertions.assertEquals(saved.getDescription(), testFindEquals.getDescription());
    }
}
