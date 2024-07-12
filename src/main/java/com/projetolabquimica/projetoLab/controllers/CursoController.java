package com.projetolabquimica.projetoLab.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetolabquimica.projetoLab.model.Curso;
import com.projetolabquimica.projetoLab.services.CursoService;

@RestController
@RequestMapping(path = "/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping
	public ResponseEntity<List<Curso>> findAll() {
		List<Curso> cursos = cursoService.findAll();
		return ResponseEntity.ok().body(cursos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Long id) {
		Curso curso = cursoService.findById(id);
		return ResponseEntity.ok().body(curso);
	}

	@PostMapping
	public ResponseEntity<Curso> insert(@RequestBody Curso curso) {
		curso = cursoService.insert(curso);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(curso.getId()).toUri();

		return ResponseEntity.created(uri).body(curso);
	}

}
