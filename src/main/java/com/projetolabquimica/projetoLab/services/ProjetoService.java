package com.projetolabquimica.projetoLab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetolabquimica.projetoLab.model.Projeto;
import com.projetolabquimica.projetoLab.repositories.ProjetoRepository;
import com.projetolabquimica.projetoLab.services.exceptions.DatabaseException;
import com.projetolabquimica.projetoLab.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;

	public List<Projeto> findAll() {
		return repository.findAll();
	}

	public Projeto findById(Long id) {
		Optional<Projeto> projeto = repository.findById(id);
		return projeto.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Projeto insert(Projeto projeto) {
		return repository.save(projeto);
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

	public Projeto update(Long id, Projeto projeto) {
		try {
			Projeto entity = repository.getReferenceById(id);
			updateData(entity, projeto);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Projeto entity, Projeto projeto) {
		// Atualize os campos conforme necessário, por exemplo:
		// entity.setName(projeto.getName());
	}
}
