package com.projetolabquimica.projetoLab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetolabquimica.projetoLab.model.Reagente;

public interface ReagenteRepository extends JpaRepository<Reagente, Long> {
}
