package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.Inspecao;
import com.obra.obras.domain.repository.InspecaoRepository;
import com.obra.obras.domain.repository.ObraRepository;

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
@RequestMapping("/api/inspecoes")
public class InspecaoController {

    private InspecaoRepository inspecaoRepository;

    public InspecaoController(InspecaoRepository inspecaoRepository) {
        this.inspecaoRepository = inspecaoRepository;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(OK)
    public Inspecao getInspecoesById(@PathVariable Integer id) {
        return inspecaoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inspeção não encontrada"));
    }

    @GetMapping
    public List<Inspecao> find(Inspecao filtro) {
        ExampleMatcher encontrar = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example exemplo = Example.of(filtro, encontrar);
        return inspecaoRepository.findAll(exemplo);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Inspecao save(@RequestBody Inspecao inspecao) {
        return inspecaoRepository.save(inspecao);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        inspecaoRepository.findById(id)
                .map(inspecao -> {
                    inspecaoRepository.delete(inspecao);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Inspeção não encontrada"));
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id,
            @RequestBody Inspecao inspecao) {
        inspecaoRepository
                .findById(id)
                .map(inspecaoExistente -> {
                    inspecao.setId(inspecaoExistente.getId());
                    inspecaoRepository.save(inspecao);
                    return inspecaoExistente;
                }).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                        "Inspeção não encontrada"));
    }

}
