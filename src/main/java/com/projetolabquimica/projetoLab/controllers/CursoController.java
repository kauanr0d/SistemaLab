package com.projetolabquimica.projetoLab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetolabquimica.projetoLab.model.Curso;
import com.projetolabquimica.projetoLab.services.CursoService;

@RestController
@RequestMapping(path = "/cursos")
public class CursoController  {
 
	@Autowired
	private CursoService cursoService;
	
	@GetMapping
	public ResponseEntity<List<Curso>> findAll(){
		List<Curso> cursos = cursoService.findAll();
		return ResponseEntity.ok().body(cursos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Long id){
		Curso curso = cursoService.findById(id);
		return ResponseEntity.ok().body(curso);
	}
	
}
