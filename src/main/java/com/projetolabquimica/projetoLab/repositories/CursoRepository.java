package com.projetolabquimica.projetoLab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetolabquimica.projetoLab.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
