package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.Obra;
import com.obra.obras.domain.repository.ObraRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import static org.springframework.http.HttpStatus.*;

import java.util.List;

@RestController
@RequestMapping("/api/obras")
public class ObraController {

    private ObraRepository obraRepository;

    public ObraController(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(OK)
    public Obra getObraById(@PathVariable Integer id) {
        return obraRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Obra não encontrada"));
    }

    @GetMapping
    public List<Obra> find(Obra filtro) {
        ExampleMatcher encontrar = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example exemplo = Example.of(filtro, encontrar);
        return obraRepository.findAll(exemplo);

    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Obra save(@RequestBody Obra obra) {
        return obraRepository.save(obra);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        obraRepository.findById(id)
                .map(obra -> {
                    obraRepository.delete(obra);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Obra não encontrada"));
    }


    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id,
                       @RequestBody Obra obra) {
        obraRepository
                .findById(id)
                .map(obraExistente -> {
                    obra.setId(obraExistente.getId());

                    obraRepository.save(obra);
                    return obraExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Obra não encontrada"));
    }
}




