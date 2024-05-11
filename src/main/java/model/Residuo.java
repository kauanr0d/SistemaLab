package model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import model.Enums.StatusResiduos;

@Entity
@Table(schema = "LabQ")
public class Residuo implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idResiduo;
  private String NomeResiduo;
  private LocalDate dataCadastro;
  private StatusResiduos status;
  private CategoriaResiduo categoria;
}
