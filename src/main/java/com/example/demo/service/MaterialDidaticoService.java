package com.example.demo.service;

import com.example.demo.model.Aluno;
import com.example.demo.model.MaterialDidatico;
import com.example.demo.repository.MaterialDidaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialDidaticoService {

    @Autowired
    private MaterialDidaticoRepository materialDidaticoRepository;

    public MaterialDidatico criar(MaterialDidatico materialDidatico) {
        return materialDidaticoRepository.save(materialDidatico);
    }

    public List<MaterialDidatico> listar() {
        return materialDidaticoRepository.findAll();
    }

    public MaterialDidatico buscarPorId(String id) {
        return materialDidaticoRepository.findById(id).get();
    }

    public MaterialDidatico atualizar(MaterialDidatico materialDidatico) {
        return materialDidaticoRepository.save(materialDidatico);
    }

    public void excluir(String id) {
        materialDidaticoRepository.deleteById(id);
    }
}
