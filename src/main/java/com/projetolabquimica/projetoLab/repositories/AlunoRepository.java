package com.projetolabquimica.projetoLab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projetolabquimica.projetoLab.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	@Query("SELECT a FROM Aluno a WHERE TYPE(a) = Aluno ORDER BY a.dataNascimento ASC LIMIT 1")
	Aluno buscarAlunoMaisVelho();

	@Query("SELECT a FROM Aluno a WHERE a.matricula = ?1")
	Aluno findByMatricula(String matricula);

}
