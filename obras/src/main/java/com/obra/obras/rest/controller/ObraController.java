package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.Obra;
import com.obra.obras.domain.repository.ObraRepository;
import com.obra.obras.rest.dto.ObraDTO;
import com.obra.obras.service.ObraService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import static org.springframework.http.HttpStatus.*;

import java.util.List;

@RestController
@RequestMapping("/api/obras")
public class ObraController {

    private ObraRepository obraRepository;

    private ObraService obraService;

    public ObraController(ObraRepository obraRepository, ObraService obraService) {
        this.obraRepository = obraRepository;
        this.obraService = obraService;
    }

// colocar para retorna um DTO
    @GetMapping(value = "{id}")
    @ResponseStatus(OK)
    public Obra getObraById(@PathVariable Integer id) {
        return obraRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Obra não encontrada"));
    }

    //passar para o DTO
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
    public Obra save ( @RequestBody @Validated ObraDTO obraDTO){
        Obra obra = obraService.salvar(obraDTO);
        return obra;
    }
//colocar para retornar um DTO
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

//retorna um DTO
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










