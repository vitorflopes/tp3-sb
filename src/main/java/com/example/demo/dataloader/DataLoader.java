package com.example.demo.dataloader;

import com.example.demo.model.Aluno;
import com.example.demo.model.Curso;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void run(String... args) throws Exception {
        Curso curso1 = new Curso("Spring Boot");
        Curso curso2 = new Curso("Projeto de Bloco");
        cursoRepository.saveAll(List.of(curso1, curso2));

        Aluno aluno1 = new Aluno("Vitor");
        aluno1.getCursos().add(curso1);
        alunoRepository.save(aluno1);

        Aluno aluno2 = new Aluno("Lopes");
        aluno2.getCursos().addAll(List.of(curso1, curso2));
        alunoRepository.save(aluno2);
    }
}
