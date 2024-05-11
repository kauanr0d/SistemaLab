package model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "LabQ")
public class Aluno extends Usuario implements Serializable {
	public Aluno(Integer id, String nome, String cPF, LocalDate dataNascimento, String telefone, String email) {
		super(id, nome, cPF, dataNascimento, telefone, email);
	}
	@Column(unique = true, nullable = false)
	private String matricula;
	private Curso curso;
	
}
