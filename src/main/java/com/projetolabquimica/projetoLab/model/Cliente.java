package com.projetolabquimica.projetoLab.model;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
public class Cliente extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
	public Cliente(Integer id, String nome, String cPF, LocalDate dataNascimento, String telefone, String email) {
        super(id, nome, cPF, dataNascimento, telefone, email);
    }
    @OneToMany(mappedBy = "cliente")
    private List<AnaliseCliente> analisesSolicitadas;

}
