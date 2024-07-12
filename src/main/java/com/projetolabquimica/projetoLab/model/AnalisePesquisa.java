package com.projetolabquimica.projetoLab.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import com.projetolabquimica.projetoLab.model.enums.StatusAnalise;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class AnalisePesquisa extends Analise implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToMany
	@JoinTable(name = "aluno_analisepesquisa", // Nome da tabela de junção
			joinColumns = @JoinColumn(name = "analisepesquisa_id"), // Chave estrangeira para a tabela de
																	// AnalisePesquisa
			inverseJoinColumns = @JoinColumn(name = "aluno_id") // Chave estrangeira para a tabela de Aluno
	)
	private Set<Aluno> alunos;

	public AnalisePesquisa(Integer id, String nomeAnalise, String descricao, LocalDate dataInicio, LocalDate dataFim,
			StatusAnalise statusAnalise) {
		super(id, nomeAnalise, descricao, dataInicio, dataFim, statusAnalise);
	}

	public AnalisePesquisa() {

	}

}
