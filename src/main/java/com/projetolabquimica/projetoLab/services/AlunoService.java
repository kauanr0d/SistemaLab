package com.projetolabquimica.projetoLab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetolabquimica.projetoLab.model.Aluno;
import com.projetolabquimica.projetoLab.repositories.AlunoRepository;
import com.projetolabquimica.projetoLab.services.exceptions.DatabaseException;
import com.projetolabquimica.projetoLab.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Aluno findById(Long id) {
        Optional<Aluno> aluno = repository.findById(id);
        return aluno.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Aluno insert(Aluno aluno) {
        return repository.save(aluno);
    }
    
    public Aluno alunoMaisVelho() {
    	return repository.buscarAlunoMaisVelho();
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

    public Aluno update(Long id, Aluno aluno) {
        try {
            Aluno entity = repository.getReferenceById(id);
            updateData(entity, aluno);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Aluno entity, Aluno aluno) {
        // Atualize os campos conforme necessário, por exemplo:
        // entity.setName(aluno.getName());
    }
    
    public Aluno findByMatricula(String matricula) {
    	return repository.findByMatricula(matricula);
    }
}
