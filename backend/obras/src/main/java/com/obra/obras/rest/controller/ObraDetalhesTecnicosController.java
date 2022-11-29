package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.ObraDetalhesTecnicos;
import com.obra.obras.domain.repository.ObraDetalhesTecnicosRepository;
import com.obra.obras.exception.RegraNegocioException;
import com.obra.obras.rest.dto.ObraDetalhesTecnicosDTO;
import com.obra.obras.service.ObraDetalhesTecnicosService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/detalhesobra")
public class ObraDetalhesTecnicosController {

    private ObraDetalhesTecnicosRepository obraDetalhesTecnicosRepository;
    private ObraDetalhesTecnicosService obraDetalhesTecnicosService;

    public ObraDetalhesTecnicosController(ObraDetalhesTecnicosRepository obraDetalhesTecnicosRepository,
            ObraDetalhesTecnicosService obraDetalhesTecnicosService) {
        this.obraDetalhesTecnicosRepository = obraDetalhesTecnicosRepository;
        this.obraDetalhesTecnicosService = obraDetalhesTecnicosService;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(OK)
    public ObraDetalhesTecnicos getDetalhesObraById(@PathVariable Integer id) {
        return obraDetalhesTecnicosService
                .obterObraDetalhesTecnicos(id)
                .orElseThrow(() -> new RegraNegocioException("Detalhes tecnicos não encontrados. " +
                        "Por favor, verifique os campos obrigatorios e tente novamente. "));
    }

    @GetMapping
    public List<ObraDetalhesTecnicos> find(ObraDetalhesTecnicosDTO filtro) {
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
    public ObraDetalhesTecnicos save(@RequestBody ObraDetalhesTecnicosDTO obraDetalhesTecnicosDTO) {
        return obraDetalhesTecnicosService.salvar(obraDetalhesTecnicosDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        obraDetalhesTecnicosRepository.findById(id)
                .map(obraDetalhesTecnicos -> {
                    obraDetalhesTecnicosRepository.delete(obraDetalhesTecnicos);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new RegraNegocioException("Detalhes tecnicos não encontrados. " +
                        "Por favor, verifique os campos obrigatorios e tente novamente. "));
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id,
            @RequestBody ObraDetalhesTecnicos obraDetalhesTecnicos) {
        obraDetalhesTecnicosService.atualizaObraDetalhesTecnicos(id, obraDetalhesTecnicos);
    }

}
