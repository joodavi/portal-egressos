package br.ufma.backend.repository;

import br.ufma.backend.entity.model.Curso;
import br.ufma.backend.entity.repository.CursoRepository;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class CursoRepositoryTest {
    @Autowired
    CursoRepository repository;

    @Test
    public void shouldSaveCurso() {
        Curso newCurso = Curso.builder().name("name").level("nivel").build();

        Curso saved = repository.save(newCurso);

        Assertions.assertNotNull(saved);
        Assertions.assertEquals(newCurso.getName(), saved.getName());
        Assertions.assertEquals(newCurso.getLevel(), saved.getLevel());
    }

    @Test
    public void shouldDeleteCurso() {
        Curso newCurso = Curso.builder().name("name").level("nivel").build();

        Curso saved = repository.save(newCurso);

        repository.deleteById(saved.getId());

        Optional<Curso> testDelete = repository.findById(saved.getId());
        Assertions.assertTrue(testDelete.isEmpty());
    }

    @Test
    public void shouldUpdateCurso() {
        Curso newCurso = Curso.builder().name("name").level("nivel").build();

        Curso saved = repository.save(newCurso);

        saved.setName("new name");
        saved.setLevel("new level");

        Curso updateCurso = repository.save(saved);

        Assertions.assertNotNull(updateCurso);
        Assertions.assertEquals(saved.getName(), updateCurso.getName());
        Assertions.assertEquals(saved.getLevel(), updateCurso.getLevel());
    }

    @Test
    public void shouldFindCursoByName() {
        Curso newCurso = Curso.builder().name("name").level("nivel").build();

        Curso saved = repository.save(newCurso);

        Optional<Curso> testFind = repository.findByName(saved.getName());
        Curso testFindEquals = testFind.get();

        Assertions.assertFalse(testFind.isEmpty());
        Assertions.assertEquals(saved.getId(), testFindEquals.getId());
        Assertions.assertEquals(saved.getName(), testFindEquals.getName());
        Assertions.assertEquals(saved.getLevel(), testFindEquals.getLevel());
    }
}
