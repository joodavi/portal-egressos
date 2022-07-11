package br.ufma.backend.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.ufma.backend.entity.model.Contato;
import br.ufma.backend.entity.repository.ContatoRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class ContatoRepositoryTest {
    @Autowired
    ContatoRepository repository;

    @Test
    public void shouldSaveContato() {
        Contato newContato = Contato.builder().name("name").urlLogo("urlLogo").build();

        Contato saved = repository.save(newContato);

        Assertions.assertNotNull(saved);
        Assertions.assertEquals(newContato.getName(), saved.getName());
        Assertions.assertEquals(newContato.getUrlLogo(), saved.getUrlLogo());
    }

    @Test
    public void shouldDeleteContato() {
        Contato newContato = Contato.builder().name("name").urlLogo("urlLogo").build();

        Contato saved = repository.save(newContato);

        repository.deleteById(saved.getId());

        Optional<Contato> testDelete = repository.findById(saved.getId());
        Assertions.assertTrue(testDelete.isEmpty());
    }

    @Test
    public void shouldUpdateContato() {
        Contato newContato = Contato.builder().name("name").urlLogo("urlLogo").build();

        Contato saved = repository.save(newContato);

        saved.setName("new name");
        saved.setUrlLogo("urlLogo");

        Contato updateContato = repository.save(saved);

        Assertions.assertNotNull(updateContato);
        Assertions.assertEquals(saved.getName(), updateContato.getName());
        Assertions.assertEquals(saved.getUrlLogo(), updateContato.getUrlLogo());
    }

    @Test
    public void shouldFindContatoByName() {
        Contato newContato = Contato.builder().name("name").urlLogo("urlLogo").build();

        Contato saved = repository.save(newContato);

        Optional<Contato> testFind = repository.findByName(saved.getName());
        Contato testFindEquals = testFind.get();

        Assertions.assertFalse(testFind.isEmpty());
        Assertions.assertEquals(saved.getId(), testFindEquals.getId());
        Assertions.assertEquals(saved.getName(), testFindEquals.getName());
        Assertions.assertEquals(saved.getUrlLogo(), testFindEquals.getUrlLogo());
    }
}
