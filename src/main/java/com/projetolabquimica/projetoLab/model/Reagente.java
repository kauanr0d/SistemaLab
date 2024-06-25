package com.projetolabquimica.projetoLab.model;
 


import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reagente implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReagente;

    private String nomeReagente;
    private LocalDate validadeReagente;
    private String fabricante;
    private Integer lote;

    @ManyToOne
    @JoinColumn(name = "id_categoria",foreignKey = @ForeignKey(value = ConstraintMode.PROVIDER_DEFAULT))
    private CategoriaReagente categoria;

    
    
    public Reagente(Integer idReagente, String nomeReagente, LocalDate validadeReagente, String fabricante,
			Integer lote, CategoriaReagente categoria) {
		super();
		this.idReagente = idReagente;
		this.nomeReagente = nomeReagente;
		this.validadeReagente = validadeReagente;
		this.fabricante = fabricante;
		this.lote = lote;
		this.categoria = categoria;
	}
    
    public Reagente() {
	
	}

	// Getters and setters
    public Integer getIdReagente() {
        return idReagente;
    }
 
    public void setIdReagente(Integer idReagente) {
        this.idReagente = idReagente;
    }

    public String getNomeReagente() {
        return nomeReagente;
    }

    public void setNomeReagente(String nomeReagente) {
        this.nomeReagente = nomeReagente;
    }

    public LocalDate getValidadeReagente() {
        return validadeReagente;
    }

}
