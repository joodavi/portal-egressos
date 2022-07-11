package br.ufma.backend.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.ufma.backend.entity.model.Egresso;
import br.ufma.backend.entity.repository.EgressoRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class EgressoRepositoryTest {
    @Autowired
    EgressoRepository repository;

    @Test
    public void shouldSaveEgresso() {
        Egresso newEgresso = Egresso.builder().cpf("cpf").email("email").name("name").resume("resume").urlPhoto("urlPhoto").build();

        Egresso saved = repository.save(newEgresso);

        Assertions.assertNotNull(saved);
        Assertions.assertEquals(newEgresso.getCpf(), saved.getCpf());
        Assertions.assertEquals(newEgresso.getEmail(), saved.getEmail());
        Assertions.assertEquals(newEgresso.getName(), saved.getName());
        Assertions.assertEquals(newEgresso.getResume(), saved.getResume());
        Assertions.assertEquals(newEgresso.getUrlPhoto(), saved.getUrlPhoto());
    }

    @Test
    public void shouldDeleteEgresso() {
        Egresso newEgresso = Egresso.builder().cpf("cpf").email("email").name("name").resume("resume").urlPhoto("urlPhoto").build();

        Egresso saved = repository.save(newEgresso);

        repository.deleteById(saved.getId());

        Optional<Egresso> testDelete = repository.findById(saved.getId());
        Assertions.assertTrue(testDelete.isEmpty());
    }

    @Test
    public void shouldUpdateEgresso() {
        Egresso newEgresso = Egresso.builder().cpf("cpf").email("email").name("name").resume("resume").urlPhoto("urlPhoto").build();

        Egresso saved = repository.save(newEgresso);

        saved.setName("new name");
        saved.setCpf("new cpf");
        saved.setEmail("new email");
        saved.setResume("new resume");
        saved.setUrlPhoto("new urlphoto");

        Egresso updateEgresso = repository.save(saved);

        Assertions.assertNotNull(updateEgresso);
        Assertions.assertEquals(saved.getCpf(), updateEgresso.getCpf());
        Assertions.assertEquals(saved.getEmail(), updateEgresso.getEmail());
        Assertions.assertEquals(saved.getName(), updateEgresso.getName());
        Assertions.assertEquals(saved.getResume(), updateEgresso.getResume());
        Assertions.assertEquals(saved.getUrlPhoto(), updateEgresso.getUrlPhoto());
    }

    @Test
    public void shouldFindEgressoByName() {
        Egresso newEgresso = Egresso.builder().cpf("cpf").email("email").name("name").resume("resume").urlPhoto("urlPhoto").build();

        Egresso saved = repository.save(newEgresso);

        Optional<Egresso> testFindByName = repository.findByName(saved.getName());
        Egresso testFindEqualsName = testFindByName.get();

        Assertions.assertFalse(testFindByName.isEmpty());
        Assertions.assertEquals(saved.getCpf(), testFindEqualsName.getCpf());
        Assertions.assertEquals(saved.getEmail(), testFindEqualsName.getEmail());
        Assertions.assertEquals(saved.getName(), testFindEqualsName.getName());
        Assertions.assertEquals(saved.getResume(), testFindEqualsName.getResume());
        Assertions.assertEquals(saved.getUrlPhoto(), testFindEqualsName.getUrlPhoto());
    }

    @Test
    public void shouldFindEgressoByEmail() {
        Egresso newEgresso = Egresso.builder().cpf("cpf").email("email").name("name").resume("resume").urlPhoto("urlPhoto").build();

        Egresso saved = repository.save(newEgresso);

        Optional<Egresso> testFindByEmail = repository.findByEmail(saved.getEmail());
        Egresso testFindEqualsEmail = testFindByEmail.get();

        Assertions.assertFalse(testFindByEmail.isEmpty());
        Assertions.assertEquals(saved.getCpf(), testFindEqualsEmail.getCpf());
        Assertions.assertEquals(saved.getEmail(), testFindEqualsEmail.getEmail());
        Assertions.assertEquals(saved.getEmail(), testFindEqualsEmail.getEmail());
        Assertions.assertEquals(saved.getResume(), testFindEqualsEmail.getResume());
        Assertions.assertEquals(saved.getUrlPhoto(), testFindEqualsEmail.getUrlPhoto());
    }

    @Test
    public void shouldFindEgressoByCpf() {
        Egresso newEgresso = Egresso.builder().cpf("cpf").email("email").name("name").resume("resume").urlPhoto("urlPhoto").build();

        Egresso saved = repository.save(newEgresso);

        Optional<Egresso> testFindByCpf = repository.findByCpf(saved.getCpf());
        Egresso testFindEqualsCpf = testFindByCpf.get();

        Assertions.assertFalse(testFindByCpf.isEmpty());
        Assertions.assertEquals(saved.getCpf(), testFindEqualsCpf.getCpf());
        Assertions.assertEquals(saved.getCpf(), testFindEqualsCpf.getCpf());
        Assertions.assertEquals(saved.getCpf(), testFindEqualsCpf.getCpf());
        Assertions.assertEquals(saved.getResume(), testFindEqualsCpf.getResume());
        Assertions.assertEquals(saved.getUrlPhoto(), testFindEqualsCpf.getUrlPhoto());
    }
}
