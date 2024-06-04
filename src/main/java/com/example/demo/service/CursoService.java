package com.example.demo.service;

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Cacheable("cursos")
    public List<Curso> buscarTodosCursos() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cursoRepository.findAll();
    }

    public Curso criar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).get();
    }

    public Curso atualizar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void excluir(Long id) {
        cursoRepository.deleteById(id);
    }
}
