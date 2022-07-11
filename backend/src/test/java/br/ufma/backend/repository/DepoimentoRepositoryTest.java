package br.ufma.backend.repository;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.ufma.backend.entity.model.Depoimento;
import br.ufma.backend.entity.model.Egresso;
import br.ufma.backend.entity.repository.DepoimentoRepository;
import br.ufma.backend.entity.repository.EgressoRepository;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class DepoimentoRepositoryTest {
    @Autowired
    DepoimentoRepository repository;

    @Autowired
    EgressoRepository egressoRepository;

    @Test
    public void shouldSaveDepoimento() {
        LocalDate localDate = LocalDate.now();
        
        Egresso newEgresso = Egresso.builder().cpf("cpf").email("email").name("name").resume("resume").urlPhoto("urlPhoto").build();

        Egresso savedEgresso = egressoRepository.save(newEgresso);

        Depoimento newDepoimento = Depoimento.builder().egresso(savedEgresso).text("text").date(localDate).build();

        Depoimento saved = repository.save(newDepoimento);

        Assertions.assertNotNull(saved);
        Assertions.assertEquals(newDepoimento.getEgresso(), saved.getEgresso());
        Assertions.assertEquals(newDepoimento.getText(), saved.getText());
        Assertions.assertEquals(newDepoimento.getDate(), saved.getDate());
    }

    @Test
    public void shouldDeleteDepoimento() {
        LocalDate localDate = LocalDate.now();
        
        Egresso newEgresso = Egresso.builder().cpf("cpf").email("email").name("name").resume("resume").urlPhoto("urlPhoto").build();

        Egresso savedEgresso = egressoRepository.save(newEgresso);

        Depoimento newDepoimento = Depoimento.builder().egresso(savedEgresso).text("text").date(localDate).build();

        Depoimento saved = repository.save(newDepoimento);

        repository.deleteById(saved.getId());

        Optional<Depoimento> testDelete = repository.findById(saved.getId());
        Assertions.assertTrue(testDelete.isEmpty());
    }

    @Test
    public void shouldUpdateDepoimento() {
        LocalDate localDate = LocalDate.now();
        LocalDate newLocalDate = LocalDate.of(2000, 06, 25);
        
        Egresso newEgresso = Egresso.builder().cpf("cpf").email("email").name("name").resume("resume").urlPhoto("urlPhoto").build();

        Egresso savedEgresso = egressoRepository.save(newEgresso);

        Depoimento newDepoimento = Depoimento.builder().egresso(savedEgresso).text("text").date(localDate).build();

        Depoimento saved = repository.save(newDepoimento);

        saved.setText("new text");
        saved.setDate(newLocalDate);

        Depoimento updateDepoimento = repository.save(saved);

        Assertions.assertNotNull(updateDepoimento);
        Assertions.assertEquals(saved.getText(), updateDepoimento.getText());
        Assertions.assertEquals(saved.getDate(), updateDepoimento.getDate());
    }

    @Test
    public void shouldFindDepoimentoByEgresso() {
        LocalDate localDate = LocalDate.now();
        
        Egresso newEgresso = Egresso.builder().cpf("cpf").email("email").name("name").resume("resume").urlPhoto("urlPhoto").build();

        Egresso savedEgresso = egressoRepository.save(newEgresso);

        Depoimento newDepoimento = Depoimento.builder().egresso(savedEgresso).text("text").date(localDate).build();

        Depoimento saved = repository.save(newDepoimento);

        Optional<Depoimento> testFindByEgresso = repository.findByEgresso((saved.getEgresso()));
        Depoimento testFindEqualsEgresso = testFindByEgresso.get();

        Assertions.assertFalse(testFindByEgresso.isEmpty());
        Assertions.assertEquals(saved.getText(), testFindEqualsEgresso.getText());
        Assertions.assertEquals(saved.getDate(), testFindEqualsEgresso.getDate());
    }
}
