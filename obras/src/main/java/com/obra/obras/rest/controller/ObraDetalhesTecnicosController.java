package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.ObraDetalhesTecnicos;
import com.obra.obras.domain.repository.ObraDetalhesTecnicosRep;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalhesobra")
public class ObraDetalhesTecnicosController {

    private ObraDetalhesTecnicosRep obraDetalhesTecnicosRep;

    public ObraDetalhesTecnicosController(ObraDetalhesTecnicosRep obraDetalhesTecnicosRep) {
        this.obraDetalhesTecnicosRep = obraDetalhesTecnicosRep;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getDetalhesObraById(@PathVariable Integer id) {
        Optional<ObraDetalhesTecnicos> detalhesTecnicos = obraDetalhesTecnicosRep.findById(id);
        if(detalhesTecnicos.isPresent()){
            return ResponseEntity.ok(detalhesTecnicos.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ObraDetalhesTecnicos>> getAll() {
        return new ResponseEntity<>(obraDetalhesTecnicosRep.findAll() , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ObraDetalhesTecnicos obraDetalhesTecnicos){
        ObraDetalhesTecnicos obraDetalhesTecnicosSalva = obraDetalhesTecnicosRep.save(obraDetalhesTecnicos);
        return ResponseEntity.ok(obraDetalhesTecnicosSalva);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<ObraDetalhesTecnicos> detalhesTecnicos = obraDetalhesTecnicosRep.findById(id);
        if(detalhesTecnicos.isPresent()){
            obraDetalhesTecnicosRep.delete(detalhesTecnicos.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
