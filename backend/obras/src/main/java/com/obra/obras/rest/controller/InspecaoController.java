package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.Inspecao;
import com.obra.obras.domain.repository.InspecaoRepository;
import com.obra.obras.exception.RegraNegocioException;
import com.obra.obras.service.InspecaoService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/inspecoes")
public class InspecaoController {

    private InspecaoRepository inspecaoRepository;
    private InspecaoService inspecaoService;

    public InspecaoController(InspecaoRepository inspecaoRepository, InspecaoService inspecaoService) {
        this.inspecaoRepository = inspecaoRepository;
        this.inspecaoService = inspecaoService;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(OK)
    public Inspecao getInspecoesById(@PathVariable Integer id) {
        return inspecaoService
                .obterInspecao(id)
                .orElseThrow(() -> new RegraNegocioException("Inspecao não encontrada. " +
                "Por favor, verifique os campos obrigatorios e tente novamente. "));
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
        return inspecaoService.salvar(inspecao);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        inspecaoRepository.findById(id)
                .map(inspecao -> {
                    inspecaoRepository.delete(inspecao);
                    return Void.TYPE;
                }).orElseThrow(() -> new RegraNegocioException("Inspeção não encontrada. " +
                        "Por favor, verifique os campos obrigatorios e tente novamente. "));
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id,
            @RequestBody Inspecao inspecao) {
        inspecaoService.atualizaInspecao(id, inspecao);
    }

}
