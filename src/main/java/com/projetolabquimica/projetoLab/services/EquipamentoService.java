package com.projetolabquimica.projetoLab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetolabquimica.projetoLab.model.Equipamento;
import com.projetolabquimica.projetoLab.repositories.EquipamentoRepository;
import com.projetolabquimica.projetoLab.services.exceptions.DatabaseException;
import com.projetolabquimica.projetoLab.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EquipamentoService {

	@Autowired
	private EquipamentoRepository repository;

	public List<Equipamento> findAll() {
		return repository.findAll();
	}

	public Equipamento findById(Long id) {
		Optional<Equipamento> equipamento = repository.findById(id);
		return equipamento.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Equipamento insert(Equipamento equipamento) {
		return repository.save(equipamento);
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

	public Equipamento update(Long id, Equipamento equipamento) {
		try {
			Equipamento entity = repository.getReferenceById(id);
			updateData(entity, equipamento);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Equipamento entity, Equipamento equipamento) {
		// Atualize os campos conforme necessário, por exemplo:
		// entity.setName(equipamento.getName());
	}
}
