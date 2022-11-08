package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.ObraLocalizacao;
import com.obra.obras.domain.repository.ObraLocalizacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/obralocal")
public class ObraLocalizacaoController {

    private ObraLocalizacaoRepository obraLocalizacaoRepository;

    public ObraLocalizacaoController(ObraLocalizacaoRepository obraLocalizacaoRepository) {
        this.obraLocalizacaoRepository = obraLocalizacaoRepository;
    }


    @GetMapping(value = "{id}")
    public ResponseEntity getObraLocalById(@PathVariable Integer id) {
        Optional<ObraLocalizacao> obraLocal = obraLocalizacaoRepository.findById(id);
        if(obraLocal.isPresent()){
            return ResponseEntity.ok(obraLocal.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ObraLocalizacao>> getAll() {
       return new ResponseEntity<>(obraLocalizacaoRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ObraLocalizacao obraLocalizacao){
        ObraLocalizacao obraLocalizacaoSalva = obraLocalizacaoRepository.save(obraLocalizacao);
        return ResponseEntity.ok(obraLocalizacaoSalva);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<ObraLocalizacao> detalhesTecnicos = obraLocalizacaoRepository.findById(id);
        if(detalhesTecnicos.isPresent()){
            obraLocalizacaoRepository.delete(detalhesTecnicos.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
