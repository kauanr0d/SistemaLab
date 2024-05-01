package model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Reagente implements Serializable {

<<<<<<< HEAD
  @Id
=======
  private static final long serialVersionUID = 1L;

@Id
>>>>>>> 082304b (Analise)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idReagente;

  private String nomeReagente;
  private LocalDate validadeReagente;
  private String fabricante;
  private Integer lote;
  private CategoriaReagente categoria;
}
