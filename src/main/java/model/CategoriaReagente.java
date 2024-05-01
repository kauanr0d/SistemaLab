package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CategoriaReagente implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long categoriaId;
  private String nomeCategoria;
  private List<Reagente> reagentes = new ArrayList<>();
}
