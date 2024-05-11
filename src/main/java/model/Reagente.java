package model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(schema = "LabQ")
public class Reagente implements Serializable {


  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idReagente;

  private String nomeReagente;
  private LocalDate validadeReagente;
  private String fabricante;
  private Integer lote;
  private CategoriaReagente categoria;
}
