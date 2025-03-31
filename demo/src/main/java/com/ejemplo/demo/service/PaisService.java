package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Pais;
import com.ejemplo.demo.repository.PaisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {
    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public List<Pais> obtenerTodos() {
        return paisRepository.findAll();
    }

    public Optional<Pais> obtenerPorId(Long id) {
        return paisRepository.findById(id);
    }

    public Optional<Pais> obtenerPorNombre(String nombre) {
        return paisRepository.findByNombre(nombre);
    }

    public Pais guardarPais(Pais pais) {
        return paisRepository.save(pais);
    }

    public void eliminarPais(Long id) {
        paisRepository.deleteById(id);
    }
}