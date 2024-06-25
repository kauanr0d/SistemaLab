package com.projetolabquimica.projetoLab.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetolabquimica.projetoLab.model.Aluno;
import com.projetolabquimica.projetoLab.model.Curso;
import com.projetolabquimica.projetoLab.repositories.AlunoRepository;
import com.projetolabquimica.projetoLab.repositories.CursoRepository;

@Configuration
@Profile("dev")
public class TesteConfig implements CommandLineRunner {
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void run(String... args) throws Exception {
        Curso curso = new Curso("Licenciatura em Química");
        curso = cursoRepository.save(curso); 
        
        Aluno aluno1 = new Aluno(null, "João Silva", "123.456.789-00", LocalDate.of(1990, 5, 15), "1234-5678", "joao.silva@example.com");
        Aluno aluno2 = new Aluno(null, "Jeca Tatu", "987.654.321-00", LocalDate.of(1992, 8, 22), "8765-4321", "jeca.tatu@example.com", "20231234", null);
        
        aluno1.setCurso(curso);
        aluno2.setCurso(curso);
        Curso curso2 = new Curso("Licenciatura em Biologia");
        Curso curso3 = new Curso("Engenharia Elétrica");

        cursoRepository.saveAll(Arrays.asList(curso2,curso3));
        
        alunoRepository.saveAll(Arrays.asList(aluno1, aluno2));
    }
}
