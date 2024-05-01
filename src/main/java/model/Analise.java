package model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import model.Enums.StatusAnalise;

@Entity 
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Analise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nome;
    private String descricaoAnalise;
    private LocalDate inicio;
    private LocalDate fim;
    private StatusAnalise status;
    
}
  