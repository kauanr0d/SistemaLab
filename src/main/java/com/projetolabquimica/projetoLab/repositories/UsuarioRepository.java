package com.projetolabquimica.projetoLab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetolabquimica.projetoLab.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
