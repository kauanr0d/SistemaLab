package com.projetolabquimica.projetoLab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetolabquimica.projetoLab.model.Reagente;
import com.projetolabquimica.projetoLab.repositories.ReagenteRepository;
import com.projetolabquimica.projetoLab.services.exceptions.DatabaseException;
import com.projetolabquimica.projetoLab.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReagenteService {

	@Autowired
	private ReagenteRepository repository;

	public List<Reagente> findAll() {
		return repository.findAll();
	}

	public Reagente findById(Long id) {
		Optional<Reagente> reagente = repository.findById(id);
		return reagente.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Reagente insert(Reagente reagente) {
		return repository.save(reagente);
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

	public Reagente update(Long id, Reagente reagente) {
		try {
			Reagente entity = repository.getReferenceById(id);
			updateData(entity, reagente);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Reagente entity, Reagente reagente) {
		// Atualize os campos conforme necessário, por exemplo:
		// entity.setName(reagente.getName());
	}
}
