package com.projetolabquimica.projetoLab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetolabquimica.projetoLab.model.Analise;
import com.projetolabquimica.projetoLab.repositories.AnaliseRepository;
import com.projetolabquimica.projetoLab.services.exceptions.DatabaseException;
import com.projetolabquimica.projetoLab.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AnaliseService {

    @Autowired
    private AnaliseRepository repository;

    public List<Analise> findAll() {
        return repository.findAll();
    }

    public Analise findById(Long id) {
        Optional<Analise> analise = repository.findById(id);
        return analise.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Analise insert(Analise analise) {
        return repository.save(analise);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Analise update(Long id, Analise analise) {
        try {
            Analise entity = repository.getReferenceById(id);
            updateData(entity, analise);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Analise entity, Analise analise) {
        // Atualize os campos conforme necessário, por exemplo:
        // entity.setName(analise.getName());
    }
}
