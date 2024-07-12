package com.projetolabquimica.projetoLab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetolabquimica.projetoLab.model.Curso;
import com.projetolabquimica.projetoLab.repositories.CursoRepository;
import com.projetolabquimica.projetoLab.services.exceptions.DatabaseException;
import com.projetolabquimica.projetoLab.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;

	public List<Curso> findAll() {
		return repository.findAll();
	}

	public Curso findById(Long id) {
		Optional<Curso> curso = repository.findById(id);
		return curso.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Curso insert(Curso curso) {
		return repository.save(curso);
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

	public Curso update(Long id, Curso curso) {
		try {
			Curso entity = repository.getReferenceById(id);
			updateData(entity, curso);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Curso entity, Curso curso) {
		// Atualize os campos conforme necessário, por exemplo:
		// entity.setName(curso.getName());
	}
}
