
package com.projetolabquimica.projetoLab.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Vidraria implements Serializable {

	public Vidraria() {
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVidraria;
	private String nomeVidraria;
	private Integer qtdVidraria;

	@Override
	public int hashCode() {
		return Objects.hash(idVidraria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vidraria other = (Vidraria) obj;
		return Objects.equals(idVidraria, other.idVidraria);
	}

}
