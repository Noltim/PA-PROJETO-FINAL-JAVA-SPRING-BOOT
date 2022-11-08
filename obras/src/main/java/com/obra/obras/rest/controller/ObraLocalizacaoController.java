package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.ObraLocalizacao;
import com.obra.obras.domain.repository.ObraLocalizacaoRepository;
import com.obra.obras.domain.repository.ObraRepository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.*;

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
    public ObraLocalizacao getObraLocalById(@PathVariable Integer id) {
            return obraLocalizacaoRepository
            .findById(id)
            .orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Localização de obra não encontrada"));
    }

    @GetMapping
    public List<ObraLocalizacao>find(ObraLocalizacao filtro) {
        ExampleMatcher encontrar = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example exemplo = Example.of(filtro, encontrar);
       return obraLocalizacaoRepository.findAll(exemplo);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ObraLocalizacao save(@RequestBody ObraLocalizacao obraLocalizacao){
        return obraLocalizacaoRepository.save(obraLocalizacao);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id){
        obraLocalizacaoRepository.findById(id)
        .map(ObraLocalizacao -> {
            obraLocalizacaoRepository.delete(ObraLocalizacao);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Localização de obra não encontrada"));
        }

        @PutMapping("{id}")
        @ResponseStatus(NO_CONTENT)
        public void update(@PathVariable Integer id,
                           @RequestBody ObraLocalizacao obraLocalizacao){
            obraLocalizacaoRepository
            .findById(id)
            .map(obraLocalizacaoExistente -> {
                obraLocalizacao.setId(obraLocalizacaoExistente.getId());

                obraLocalizacaoRepository.save(obraLocalizacao);
                return obraLocalizacaoExistente;
            }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Localização de obra não encontrada"));
                           }
    }

