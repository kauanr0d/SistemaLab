package com.projetolabquimica.projetoLab.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetolabquimica.projetoLab.model.Reagente;
import com.projetolabquimica.projetoLab.services.ReagenteService;

@RestController
@RequestMapping(path = "/reagentes")
public class ReagenteController {
	
	@Autowired
	private ReagenteService reagente;
	
	@GetMapping
	public ResponseEntity<List<Reagente>> findAll(){
		List<Reagente> reagentes = reagente.findAll();
		return ResponseEntity.ok().body(reagentes);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Reagente> findById(@PathVariable Long id){
		Reagente obj = reagente.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Reagente> insert(@RequestBody Reagente obj){
		Reagente r = obj;
		reagente.insert(r);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(r.getIdReagente()).toUri();
		return ResponseEntity.created(uri).body(r);
	}
}
