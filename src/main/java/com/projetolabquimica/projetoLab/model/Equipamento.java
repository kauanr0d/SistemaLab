
package com.projetolabquimica.projetoLab.model;


import java.io.Serializable;

import com.projetolabquimica.projetoLab.model.enums.StatusEquipamento;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;



@Entity
public class Equipamento implements Serializable {
    // Construtor sem argumentos
    public Equipamento() {}

   private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idEquipamento;
  private String nomeEquipamento;
  private StatusEquipamento status;

}
