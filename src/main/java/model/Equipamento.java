package model;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;


import model.Enums.StatusEquipamento;
public class Equipamento implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idEquipamento;
  private String nomeEquipamento;
  private StatusEquipamento status;

}
