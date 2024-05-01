package model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Aluno extends Usuario implements Serializable {
	@Column(unique = true, nullable = false)
	private String matricula;
	private Curso curso;
	
}
