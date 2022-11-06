package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.ObraLocalizacao;
import com.obra.obras.domain.repository.ObraLocalizacoes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ObraLocalizacaoController {

    private ObraLocalizacoes obraLocalizacoes;

    public ObraLocalizacaoController(ObraLocalizacoes obraLocalizacoes) {
        this.obraLocalizacoes = obraLocalizacoes;
    }


    @GetMapping(value = "/api/obralocal/{id}")
    @ResponseBody
    public ResponseEntity getObraLocalById(@PathVariable Integer id) {
        Optional<ObraLocalizacao> obraLocal = obraLocalizacoes.findById(id);
        if(obraLocal.isPresent()){
            return ResponseEntity.ok(obraLocal.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/api/obralocal")
    @ResponseBody
    public ResponseEntity<List<ObraLocalizacao>> getAll() {
       return new ResponseEntity<>(obraLocalizacoes.findAll(), HttpStatus.OK);
    }
}
