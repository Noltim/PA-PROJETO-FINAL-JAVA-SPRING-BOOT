package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.ObraInspecao;
import com.obra.obras.domain.repository.ObraInspecaoRepository;
import com.obra.obras.exception.RegraNegocioException;
import com.obra.obras.service.ObraInspecaoService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/obrainspecoes")
public class ObraInspecaoController {

    private ObraInspecaoRepository obraInspecaoRepository;
    private ObraInspecaoService obraInspecaoService;

    public ObraInspecaoController(ObraInspecaoRepository obraInspecaoRepository, ObraInspecaoService obraInspecaoService) {
        this.obraInspecaoRepository = obraInspecaoRepository;
        this.obraInspecaoService = obraInspecaoService;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(OK)
    public ObraInspecao getObrasInspecoesById(@PathVariable Integer id) {
        return obraInspecaoService
                .obterObraInspecao(id)
                .orElseThrow(() -> new RegraNegocioException("Obra inspecao não encontrado. " +
                        "Por favor, verifique os campos obrigatorios e tente novamente. "));
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
        return obraInspecaoService.salvar(obraInspecao);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        obraInspecaoRepository.findById(id)
                .map(obraInspecao -> {
                    obraInspecaoRepository.delete(obraInspecao);
                    return Void.TYPE;
                }).orElseThrow(() -> new RegraNegocioException("Obra Inspecao não encontrada. " +
                        "Por favor, verifique os campos obrigatorios e tente novamente. "));
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id,
            @RequestBody @Validated ObraInspecao obraInspecao) {
        obraInspecaoService.atualizaObraInspecao(id, obraInspecao);

    }
}
