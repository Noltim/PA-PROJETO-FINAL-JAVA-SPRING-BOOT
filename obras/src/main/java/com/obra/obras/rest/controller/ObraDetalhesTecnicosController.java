package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.ObraDetalhesTecnicos;
import com.obra.obras.domain.repository.ObraDetalhesTecnicosRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/detalhesobra")
public class ObraDetalhesTecnicosController {

    private ObraDetalhesTecnicosRepository obraDetalhesTecnicosRepository;

    public ObraDetalhesTecnicosController(ObraDetalhesTecnicosRepository obraDetalhesTecnicosRepository) {
        this.obraDetalhesTecnicosRepository = obraDetalhesTecnicosRepository;
    }


    @GetMapping(value = "{id}")
    @ResponseStatus(OK)
    public ObraDetalhesTecnicos getDetalhesObraById(@PathVariable Integer id) {
        return obraDetalhesTecnicosRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Detalhes tecnicos da obra não encontrados"));
    }

    @GetMapping
    public List<ObraDetalhesTecnicos> find(ObraDetalhesTecnicos filtro) {
        ExampleMatcher encontrar = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example exemplo = Example.of(filtro, encontrar);
        return obraDetalhesTecnicosRepository.findAll(exemplo);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ObraDetalhesTecnicos save(@RequestBody ObraDetalhesTecnicos obraDetalhesTecnicos) {
        return obraDetalhesTecnicosRepository.save(obraDetalhesTecnicos);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        obraDetalhesTecnicosRepository.findById(id)
                .map(obraDetalhesTecnicos -> {
                    obraDetalhesTecnicosRepository.delete(obraDetalhesTecnicos);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Detalhes tecnicos da obra não encontrados"));
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id,
                       @RequestBody ObraDetalhesTecnicos obraDetalhesTecnicos) {
        obraDetalhesTecnicosRepository
                .findById(id)
                .map(obraDetalhesTecnicosExistente -> {
                    obraDetalhesTecnicos.setId(obraDetalhesTecnicosExistente.getId());
                    return obraDetalhesTecnicosExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Detalhes tecnicos da obra não encontrados"));
    }

}
