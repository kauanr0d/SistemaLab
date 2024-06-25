
package com.projetolabquimica.projetoLab.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CategoriaReagente implements Serializable {
    public CategoriaReagente() {}


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaId;
    private String nomeCategoria;

    @OneToMany(mappedBy = "categoria")
    private List<Reagente> reagentes = new ArrayList<>();

    // Getters and setters
    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public List<Reagente> getReagentes() {
        return reagentes;
    }

    public void setReagentes(List<Reagente> reagentes) {
        this.reagentes = reagentes;
    }
}
