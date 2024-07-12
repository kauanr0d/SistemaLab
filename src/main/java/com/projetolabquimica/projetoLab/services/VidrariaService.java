package com.projetolabquimica.projetoLab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetolabquimica.projetoLab.model.Vidraria;
import com.projetolabquimica.projetoLab.repositories.VidrariaRepository;
import com.projetolabquimica.projetoLab.services.exceptions.DatabaseException;
import com.projetolabquimica.projetoLab.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VidrariaService {

	@Autowired
	private VidrariaRepository repository;

	public List<Vidraria> findAll() {
		return repository.findAll();
	}

	public Vidraria findById(Long id) {
		Optional<Vidraria> vidraria = repository.findById(id);
		return vidraria.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Vidraria insert(Vidraria vidraria) {
		return repository.save(vidraria);
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

	public Vidraria update(Long id, Vidraria vidraria) {
		try {
			Vidraria entity = repository.getReferenceById(id);
			updateData(entity, vidraria);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Vidraria entity, Vidraria vidraria) {
		// Atualize os campos conforme necessário, por exemplo:
		// entity.setName(vidraria.getName());
	}
}
