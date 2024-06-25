package com.projetolabquimica.projetoLab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetolabquimica.projetoLab.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
