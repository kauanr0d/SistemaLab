
package com.projetolabquimica.projetoLab.model;



import java.io.Serializable;
import java.time.LocalDate;

import com.projetolabquimica.projetoLab.model.enums.StatusResiduos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class Residuo implements Serializable {
    public Residuo() {}

    private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idResiduo;
  private String NomeResiduo;
  private LocalDate dataCadastro;
  private StatusResiduos status;
  @ManyToOne
  @JoinColumn(name="categoria_residuo_id",nullable = false)
  private CategoriaResiduo categoriaResiduo;
}
