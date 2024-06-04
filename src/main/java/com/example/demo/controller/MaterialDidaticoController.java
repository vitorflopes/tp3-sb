package com.example.demo.controller;

import com.example.demo.model.MaterialDidatico;
import com.example.demo.repository.MaterialDidaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiais")
public class MaterialDidaticoController {

    @Autowired
    private MaterialDidaticoRepository repository;

    @PostMapping
    public MaterialDidatico criar(@RequestBody MaterialDidatico material) {
        return repository.save(material);
    }

    @GetMapping
    public List<MaterialDidatico> buscarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public MaterialDidatico buscarPorId(@PathVariable String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material Didático não encontrado"));
    }

    @PutMapping("/{id}")
    public MaterialDidatico atualizar(@PathVariable String id, @RequestBody MaterialDidatico material) {
        material.setId(id);
        return repository.save(material);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        repository.deleteById(id);
    }
}
