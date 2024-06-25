package com.projetolabquimica.projetoLab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetolabquimica.projetoLab.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
