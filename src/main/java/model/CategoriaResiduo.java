package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.cdi.Eager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CategoriaResiduo implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idCategoria;
  private String nomeCategoria;
  private List<Residuo> residuos = new ArrayList<>();
}
