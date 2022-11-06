package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.Inspecao;
import com.obra.obras.domain.repository.Inspecoes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
