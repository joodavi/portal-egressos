package br.ufma.backend.repository;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.ufma.backend.entity.model.Curso;
import br.ufma.backend.entity.model.CursoEgresso;
import br.ufma.backend.entity.model.Egresso;
import br.ufma.backend.entity.repository.CursoEgressoRepository;
import br.ufma.backend.entity.repository.CursoRepository;
import br.ufma.backend.entity.repository.EgressoRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class CursoEgressoRepositoryTest {
    @Autowired
    CursoEgressoRepository repository;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    EgressoRepository egressoRepository;

    @Test
    public void shouldSaveCursoEgresso() {
        LocalDate initialLocalDate = LocalDate.now();
        LocalDate finishLocalDate = LocalDate.of(2000, 06, 25);
        
        Curso newCurso = Curso.builder().name("name").level("nivel").build();

        Curso savedCurso = cursoRepository.save(newCurso); 
        
        Egresso newEgresso = Egresso.builder().cpf("cpf").email("email").name("name").resume("resume").urlPhoto("urlPhoto").build();

        Egresso savedEgresso = egressoRepository.save(newEgresso);

        CursoEgresso newCursoEgresso = CursoEgresso.builder().egresso(savedEgresso).curso(savedCurso).initialDate(initialLocalDate).finishDate(finishLocalDate).build();

        CursoEgresso saved = repository.save(newCursoEgresso);

        Assertions.assertNotNull(saved);
    }
}
