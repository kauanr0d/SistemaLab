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

import com.projetolabquimica.projetoLab.model.Aluno;
import com.projetolabquimica.projetoLab.services.AlunoService;

@RestController
@RequestMapping(path = "/alunos")
public class AlunoController {
	@Autowired
	AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll(){
		List<Aluno> lista = alunoService.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(path="/maisvelho")
	public ResponseEntity<Aluno>buscarAlunoMaisVelho(){
		Aluno alunoMaisVelho = alunoService.alunoMaisVelho();
		return ResponseEntity.ok().body(alunoMaisVelho);
	}
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Aluno>findById(@PathVariable Long id){
		Aluno obj = alunoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(path = "/matricula/{matricula}")
	public ResponseEntity<Aluno>findByMatricula(@PathVariable String matricula){
		Aluno obj = alunoService.findByMatricula(matricula);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Aluno>insert(@RequestBody Aluno a){
		a = alunoService.insert(a);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(a.getId()).toUri();
		return ResponseEntity.created(uri).body(a);
	}
	
}
