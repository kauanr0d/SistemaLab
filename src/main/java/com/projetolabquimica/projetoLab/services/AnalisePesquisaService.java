package com.projetolabquimica.projetoLab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetolabquimica.projetoLab.model.AnalisePesquisa;
import com.projetolabquimica.projetoLab.repositories.AnalisePesquisaRepository;
import com.projetolabquimica.projetoLab.services.exceptions.DatabaseException;
import com.projetolabquimica.projetoLab.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AnalisePesquisaService {

    @Autowired
    private AnalisePesquisaRepository repository;

    public List<AnalisePesquisa> findAll() {
        return repository.findAll();
    }

    public AnalisePesquisa findById(Long id) {
        Optional<AnalisePesquisa> analisepesquisa = repository.findById(id);
        return analisepesquisa.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public AnalisePesquisa insert(AnalisePesquisa analisepesquisa) {
        return repository.save(analisepesquisa);
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

    public AnalisePesquisa update(Long id, AnalisePesquisa analisepesquisa) {
        try {
            AnalisePesquisa entity = repository.getReferenceById(id);
            updateData(entity, analisepesquisa);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(AnalisePesquisa entity, AnalisePesquisa analisepesquisa) {
        // Atualize os campos conforme necessário, por exemplo:
        // entity.setName(analisepesquisa.getName());
    }
}
