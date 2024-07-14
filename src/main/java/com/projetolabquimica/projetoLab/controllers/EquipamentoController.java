package com.projetolabquimica.projetoLab.controllers;


import com.projetolabquimica.projetoLab.model.Equipamento;
import com.projetolabquimica.projetoLab.services.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {
    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping
    public ResponseEntity<List<Equipamento>> findAll(){
        List<Equipamento> equipamentos = equipamentoService.findAll();
        return ResponseEntity.ok().body(equipamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> findById(@PathVariable Long id){
        Equipamento equipamento = equipamentoService.findById(id);
        return ResponseEntity.ok().body(equipamento);
    }

    @PostMapping
    public ResponseEntity<Equipamento> create(@RequestBody Equipamento equipamento){
        Equipamento obj = equipamentoService.insert(equipamento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(obj.getIdEquipamento()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }


}
