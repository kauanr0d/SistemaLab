package model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Analise implements Serializable {
    @Id

    private Integer id;

}
  