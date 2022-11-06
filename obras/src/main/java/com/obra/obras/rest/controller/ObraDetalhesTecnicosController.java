package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.Obra;
import com.obra.obras.domain.entity.ObraDetalhesTecnicos;
import com.obra.obras.domain.repository.ObraDetalhesTecnicosRep;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
public class ObraDetalhesTecnicosController {

    private ObraDetalhesTecnicosRep obraDetalhesTecnicosRep;

    public ObraDetalhesTecnicosController(ObraDetalhesTecnicosRep obraDetalhesTecnicosRep) {
        this.obraDetalhesTecnicosRep = obraDetalhesTecnicosRep;
    }

    @GetMapping(value = "/api/detalhesobra/{id}")
    @ResponseBody
    public ResponseEntity getDetalhesObraById(@PathVariable Integer id) {
        Optional<ObraDetalhesTecnicos> detalhesTecnicos = obraDetalhesTecnicosRep.findById(id);
        if(detalhesTecnicos.isPresent()){
            return ResponseEntity.ok(detalhesTecnicos.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/api/detalhesobra")
    @ResponseBody
    public ResponseEntity<List<ObraDetalhesTecnicos>> getAll() {
        return new ResponseEntity<>(obraDetalhesTecnicosRep.findAll() , HttpStatus.OK);
    }

    @PostMapping("/api/detalhesobra")
    @ResponseBody
    public ResponseEntity save(@RequestBody ObraDetalhesTecnicos obraDetalhesTecnicos){
        ObraDetalhesTecnicos obraDetalhesTecnicosSalva = obraDetalhesTecnicosRep.save(obraDetalhesTecnicos);
        return ResponseEntity.ok(obraDetalhesTecnicosSalva);
    }
}
