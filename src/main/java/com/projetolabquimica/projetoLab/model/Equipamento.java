
package com.projetolabquimica.projetoLab.model;

import java.io.Serializable;
import java.util.Objects;

import com.projetolabquimica.projetoLab.model.enums.StatusEquipamento;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
public class Equipamento implements Serializable {
	// Construtor sem argumentos
	public Equipamento() {
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEquipamento;
	private String nomeEquipamento;
	private StatusEquipamento status;

	public Equipamento(Integer idEquipamento, String nomeEquipamento, StatusEquipamento status) {
		this.idEquipamento = idEquipamento;
		this.nomeEquipamento = nomeEquipamento;
		this.status = status;
	}
	public void Equipamento() {

	}

	public Integer getIdEquipamento() {
		return idEquipamento;
	}

	public void setIdEquipamento(Integer idEquipamento) {
		this.idEquipamento = idEquipamento;
	}

	public String getNomeEquipamento() {
		return nomeEquipamento;
	}

	public void setNomeEquipamento(String nomeEquipamento) {
		this.nomeEquipamento = nomeEquipamento;
	}

	public StatusEquipamento getStatus() {
		return status;
	}

	public void setStatus(StatusEquipamento status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Equipamento that = (Equipamento) o;
		return Objects.equals(idEquipamento, that.idEquipamento) && Objects.equals(nomeEquipamento, that.nomeEquipamento) && status == that.status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEquipamento, nomeEquipamento, status);
	}
}
