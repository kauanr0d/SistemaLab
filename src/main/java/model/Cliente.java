package model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Table;
@Table(schema = "LabQ")
public class Cliente extends Usuario implements Serializable {

    public Cliente(Integer id, String nome, String cPF, LocalDate dataNascimento, String telefone, String email) {
        super(id, nome, cPF, dataNascimento, telefone, email);
        //TODO Auto-generated constructor stub
    }

}