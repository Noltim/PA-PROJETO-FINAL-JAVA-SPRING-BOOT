package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.ObraDetalhesTecnicos;
import com.obra.obras.domain.repository.ObraDetalhesTecnicosRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalhesobra")
public class ObraDetalhesTecnicosController {

    private ObraDetalhesTecnicosRepository obraDetalhesTecnicosRepository;

    public ObraDetalhesTecnicosController(ObraDetalhesTecnicosRepository obraDetalhesTecnicosRepository) {
        this.obraDetalhesTecnicosRepository = obraDetalhesTecnicosRepository;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getDetalhesObraById(@PathVariable Integer id) {
        Optional<ObraDetalhesTecnicos> detalhesTecnicos = obraDetalhesTecnicosRepository.findById(id);
        if(detalhesTecnicos.isPresent()){
            return ResponseEntity.ok(detalhesTecnicos.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ObraDetalhesTecnicos>> getAll() {
        return new ResponseEntity<>(obraDetalhesTecnicosRepository.findAll() , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ObraDetalhesTecnicos obraDetalhesTecnicos){
        ObraDetalhesTecnicos obraDetalhesTecnicosSalva = obraDetalhesTecnicosRepository.save(obraDetalhesTecnicos);
        return ResponseEntity.ok(obraDetalhesTecnicosSalva);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<ObraDetalhesTecnicos> detalhesTecnicos = obraDetalhesTecnicosRepository.findById(id);
        if(detalhesTecnicos.isPresent()){
            obraDetalhesTecnicosRepository.delete(detalhesTecnicos.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
