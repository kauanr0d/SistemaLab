package com.projetolabquimica.projetoLab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetolabquimica.projetoLab.model.CategoriaReagente;
import com.projetolabquimica.projetoLab.repositories.CategoriaReagenteRepository;
import com.projetolabquimica.projetoLab.services.exceptions.DatabaseException;
import com.projetolabquimica.projetoLab.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaReagenteService {

	@Autowired
	private CategoriaReagenteRepository repository;

	public List<CategoriaReagente> findAll() {
		return repository.findAll();
	}

	public CategoriaReagente findById(Long id) {
		Optional<CategoriaReagente> categoriareagente = repository.findById(id);
		return categoriareagente.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public CategoriaReagente insert(CategoriaReagente categoriareagente) {
		return repository.save(categoriareagente);
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

	public CategoriaReagente update(Long id, CategoriaReagente categoriareagente) {
		try {
			CategoriaReagente entity = repository.getReferenceById(id);
			updateData(entity, categoriareagente);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(CategoriaReagente entity, CategoriaReagente categoriareagente) {
		// Atualize os campos conforme necessário, por exemplo:
		// entity.setName(categoriareagente.getName());
	}
}
