package com.projetolabquimica.projetoLab.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Aluno extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	public Aluno(Integer id, String nome, String cPF, LocalDate dataNascimento, String telefone, String email) {
		super(id, nome, cPF, dataNascimento, telefone, email);
	}

	public Aluno(Integer id, String nome, String cPF, LocalDate dataNascimento, String telefone, String email,
			String matricula, Curso curso) {
		super(id, nome, cPF, dataNascimento, telefone, email);
		this.matricula = matricula;
		this.curso = curso;
	}

	public Aluno() {
		super();
	}

	@Column(unique = true)
	private String matricula;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_curso", nullable = false)
	private Curso curso;

	@ManyToMany
	@JoinTable(name = "aluno_analisepesquisa", joinColumns = @JoinColumn(name = "aluno_id"), inverseJoinColumns = @JoinColumn(name = "analisepesquisa_id"))
	private Set<AnalisePesquisa> pesquisas;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
