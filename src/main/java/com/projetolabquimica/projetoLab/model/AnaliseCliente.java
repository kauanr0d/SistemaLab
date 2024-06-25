package com.projetolabquimica.projetoLab.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.projetolabquimica.projetoLab.model.enums.StatusAnalise;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
public class AnaliseCliente extends Analise implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente",nullable = false)
	private Cliente cliente;

 
    public AnaliseCliente(Integer id, String nomeAnalise, String descricao, LocalDate dataInicio, LocalDate dataFim,
            StatusAnalise statusAnalise) {
        super(id, nomeAnalise, descricao, dataInicio, dataFim, statusAnalise);
    }


    public AnaliseCliente(Integer id, String nomeAnalise, String descricao, LocalDate dataInicio, LocalDate dataFim,
            StatusAnalise statusAnalise, Cliente cliente) {
        super(id, nomeAnalise, descricao, dataInicio, dataFim, statusAnalise);
        this.cliente = cliente;
    }
    
    

   
}
