package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.Obra;
import com.obra.obras.domain.repository.Obras;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/obras")
public class ObraController {

    private Obras obras;

    public ObraController(Obras obras) {
        this.obras = obras;
    }

    @GetMapping(value = "{id}")
    public Obra getObraById(@PathVariable Integer id) {
        return obras
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Obra não encontrada"));
    }

    //trocar de todos o metodo de get geral por esse a baixo
    // e criar o mesmo metodo nos outros controlles
    @GetMapping
    public List<Obra> find(Obra filtro) {
        ExampleMatcher encontrar = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example exemplo = Example.of(filtro, encontrar);
        return obras.findAll(exemplo);

    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Obra save(@RequestBody Obra obra) {
        return obras.save(obra);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        obras.findById(id)
                .map(obra -> {
                    obras.delete(obra);
                    return obra;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Obra não encontrada"));
    }


    //criar o mesmo metodo nos outros controlles
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id,
                       @RequestBody Obra obra) {
        obras
                .findById(id)
                .map(obraExistente -> {
                    obra.setId(obraExistente.getId());

                    obras.save(obra);
                    return obraExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Obra não encontrada"));
    }
}




