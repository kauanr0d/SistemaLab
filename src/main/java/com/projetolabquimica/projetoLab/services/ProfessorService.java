package com.projetolabquimica.projetoLab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetolabquimica.projetoLab.model.Professor;
import com.projetolabquimica.projetoLab.repositories.ProfessorRepository;
import com.projetolabquimica.projetoLab.services.exceptions.DatabaseException;
import com.projetolabquimica.projetoLab.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public List<Professor> findAll() {
        return repository.findAll();
    }

    public Professor findById(Long id) {
        Optional<Professor> professor = repository.findById(id);
        return professor.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Professor insert(Professor professor) {
        return repository.save(professor);
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

    public Professor update(Long id, Professor professor) {
        try {
            Professor entity = repository.getReferenceById(id);
            updateData(entity, professor);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Professor entity, Professor professor) {
        // Atualize os campos conforme necessário, por exemplo:
        // entity.setName(professor.getName());
    }
}
