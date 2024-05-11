package model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import model.Enums.StatusAnalise;
@Entity
@Table(schema = "LabQ")
@Inheritance(strategy = InheritanceType.JOINED)
public class Analise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeAnalise;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private StatusAnalise statusAnalise;


}
  