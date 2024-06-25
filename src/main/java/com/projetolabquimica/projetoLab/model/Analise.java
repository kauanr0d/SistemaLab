package com.projetolabquimica.projetoLab.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.projetolabquimica.projetoLab.model.enums.StatusAnalise;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Analise implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeAnalise;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private StatusAnalise statusAnalise;
    
    @ManyToOne
    @JoinColumn(name = "id_orientador",nullable = true)
    private Professor professorOrientador;

    public Analise(Integer id, String nomeAnalise, String descricao, LocalDate dataInicio, LocalDate dataFim,
            StatusAnalise statusAnalise) {
        this.id = id;
        this.nomeAnalise = nomeAnalise;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.statusAnalise = statusAnalise;
    }
    public Analise() {
   
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Analise other = (Analise) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNomeAnalise() {
        return nomeAnalise;
    }
    public void setNomeAnalise(String nomeAnalise) {
        this.nomeAnalise = nomeAnalise;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    public StatusAnalise getStatusAnalise() {
        return statusAnalise;
    }
    public void setStatusAnalise(StatusAnalise statusAnalise) {
        this.statusAnalise = statusAnalise;
    }

    

}
  