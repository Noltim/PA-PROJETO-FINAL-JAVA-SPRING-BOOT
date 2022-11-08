package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.ObraInspecao;
import com.obra.obras.domain.repository.ObraInspecaoRepository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/obrainspecoes")
public class ObraInspecaoController {

    private ObraInspecaoRepository obraInspecaoRepository;

    public ObraInspecaoController(ObraInspecaoRepository obraInspecaoRepository) {
        this.obraInspecaoRepository = obraInspecaoRepository;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(OK)
    public ObraInspecao getObrasInspecoesById(@PathVariable Integer id) {
        return obraInspecaoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Inspeçao de obra não encontrada"));
    }

    @GetMapping
    public List<ObraInspecao> find(ObraInspecao filtro) {
        ExampleMatcher encontrar = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example exemplo = Example.of(filtro, encontrar);
        return obraInspecaoRepository.findAll(exemplo);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ObraInspecao save(@RequestBody ObraInspecao obraInspecao) {
        return obraInspecaoRepository.save(obraInspecao);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        obraInspecaoRepository.findById(id)
        .map(obraInspecao -> {
            obraInspecaoRepository.delete(obraInspecao);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
        "Inspeçao de obra não encontrada"));
    }

        @PutMapping("{id}")
        @ResponseStatus(NO_CONTENT)
        public void update(@PathVariable Integer id,
                           @RequestBody ObraInspecao obraInspecao) {
            obraInspecaoRepository
            .findById(id)
            .map(obraInspecaoExistente -> {
                obraInspecao.setId(obraInspecaoExistente.getId());
            
                obraInspecaoRepository.save(obraInspecao);
                return obraInspecaoExistente;
            }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
            "Inspeçao de obra não encontrada"));
            
        }
}


