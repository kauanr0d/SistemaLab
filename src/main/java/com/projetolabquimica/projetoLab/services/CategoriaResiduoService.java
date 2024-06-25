package com.projetolabquimica.projetoLab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetolabquimica.projetoLab.model.CategoriaResiduo;
import com.projetolabquimica.projetoLab.repositories.CategoriaResiduoRepository;
import com.projetolabquimica.projetoLab.services.exceptions.DatabaseException;
import com.projetolabquimica.projetoLab.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaResiduoService {

    @Autowired
    private CategoriaResiduoRepository repository;

    public List<CategoriaResiduo> findAll() {
        return repository.findAll();
    }

    public CategoriaResiduo findById(Long id) {
        Optional<CategoriaResiduo> categoriaresiduo = repository.findById(id);
        return categoriaresiduo.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public CategoriaResiduo insert(CategoriaResiduo categoriaresiduo) {
        return repository.save(categoriaresiduo);
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

    public CategoriaResiduo update(Long id, CategoriaResiduo categoriaresiduo) {
        try {
            CategoriaResiduo entity = repository.getReferenceById(id);
            updateData(entity, categoriaresiduo);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(CategoriaResiduo entity, CategoriaResiduo categoriaresiduo) {
        // Atualize os campos conforme necessário, por exemplo:
        // entity.setName(categoriaresiduo.getName());
    }
}
