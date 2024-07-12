package com.projetolabquimica.projetoLab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetolabquimica.projetoLab.model.Residuo;
import com.projetolabquimica.projetoLab.repositories.ResiduoRepository;
import com.projetolabquimica.projetoLab.services.exceptions.DatabaseException;
import com.projetolabquimica.projetoLab.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ResiduoService {

	@Autowired
	private ResiduoRepository repository;

	public List<Residuo> findAll() {
		return repository.findAll();
	}

	public Residuo findById(Long id) {
		Optional<Residuo> residuo = repository.findById(id);
		return residuo.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Residuo insert(Residuo residuo) {
		return repository.save(residuo);
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

	public Residuo update(Long id, Residuo residuo) {
		try {
			Residuo entity = repository.getReferenceById(id);
			updateData(entity, residuo);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Residuo entity, Residuo residuo) {
		// Atualize os campos conforme necessário, por exemplo:
		// entity.setName(residuo.getName());
	}
}
