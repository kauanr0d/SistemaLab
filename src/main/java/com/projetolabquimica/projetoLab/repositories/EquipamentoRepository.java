package com.projetolabquimica.projetoLab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetolabquimica.projetoLab.model.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
}
