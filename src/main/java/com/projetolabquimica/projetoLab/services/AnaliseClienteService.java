package com.projetolabquimica.projetoLab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetolabquimica.projetoLab.model.AnaliseCliente;
import com.projetolabquimica.projetoLab.repositories.AnaliseClienteRepository;
import com.projetolabquimica.projetoLab.services.exceptions.DatabaseException;
import com.projetolabquimica.projetoLab.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AnaliseClienteService {

    @Autowired
    private AnaliseClienteRepository repository;

    public List<AnaliseCliente> findAll() {
        return repository.findAll();
    }

    public AnaliseCliente findById(Long id) {
        Optional<AnaliseCliente> analisecliente = repository.findById(id);
        return analisecliente.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public AnaliseCliente insert(AnaliseCliente analisecliente) {
        return repository.save(analisecliente);
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

    public AnaliseCliente update(Long id, AnaliseCliente analisecliente) {
        try {
            AnaliseCliente entity = repository.getReferenceById(id);
            updateData(entity, analisecliente);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(AnaliseCliente entity, AnaliseCliente analisecliente) {
        // Atualize os campos conforme necessário, por exemplo:
        // entity.setName(analisecliente.getName());
    }
}
