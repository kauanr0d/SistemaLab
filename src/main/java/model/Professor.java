package model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "LabQ")
public class Professor extends Usuario implements Serializable {

    public Professor(Integer id, String nome, String cPF, LocalDate dataNascimento, String telefone, String email) {
        super(id, nome, cPF, dataNascimento, telefone, email);
    }

}
  