package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.Inspecao;
import com.obra.obras.domain.entity.ObraDetalhesTecnicos;
import com.obra.obras.domain.repository.Inspecoes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InspecaoController {

    private Inspecoes inspecoes;

    public InspecaoController(Inspecoes inspecoes){
        this.inspecoes = inspecoes;
    }

    @GetMapping(value = "/api/inspecoes/{id}")
    @ResponseBody
    public ResponseEntity getInspecoesById(@PathVariable Integer id) {
        Optional<Inspecao> inspecao = inspecoes.findById(id);
        if(inspecao.isPresent()){
            return ResponseEntity.ok(inspecao.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/api/inspecoes")
    @ResponseBody
    public ResponseEntity<List<Inspecao>> getAll() {
        return new ResponseEntity<>(inspecoes.findAll() , HttpStatus.OK);
    }

    @PostMapping("/api/inspecoes")
    @ResponseBody
    public ResponseEntity save(@RequestBody Inspecao inspecao){
        Inspecao inspecaoSalva = inspecoes.save(inspecao);
        return ResponseEntity.ok(inspecaoSalva);
    }

    @DeleteMapping("/api/inspecoes/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<Inspecao> inspecao = inspecoes.findById(id);
        if(inspecao.isPresent()){
            inspecoes.delete(inspecao.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
