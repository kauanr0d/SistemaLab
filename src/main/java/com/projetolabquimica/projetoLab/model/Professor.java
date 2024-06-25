package com.projetolabquimica.projetoLab.model;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Professor extends Usuario implements Serializable {

    public Professor(Integer id, String nome, String cPF, LocalDate dataNascimento, String telefone, String email) {
        super(id, nome, cPF, dataNascimento, telefone, email);
    }

    @OneToMany(mappedBy = "professorOrientador")
    private List<Analise> analises;

}
  