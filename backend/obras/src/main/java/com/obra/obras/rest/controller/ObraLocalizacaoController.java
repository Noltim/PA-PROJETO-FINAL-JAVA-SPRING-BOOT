package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.ObraLocalizacao;
import com.obra.obras.domain.repository.ObraLocalizacaoRepository;
import com.obra.obras.exception.RegraNegocioException;
import com.obra.obras.rest.dto.ObraLocalizacaoDTO;
import com.obra.obras.service.ObraLocalizacaoService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/obralocal")
public class ObraLocalizacaoController {

    private ObraLocalizacaoRepository obraLocalizacaoRepository;
    private ObraLocalizacaoService obraLocalizacaoService;

    public ObraLocalizacaoController(ObraLocalizacaoRepository obraLocalizacaoRepository,
            ObraLocalizacaoService obraLocalizacaoService) {
        this.obraLocalizacaoRepository = obraLocalizacaoRepository;
        this.obraLocalizacaoService = obraLocalizacaoService;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(OK)
    public ObraLocalizacao getObraLocalById(@PathVariable Integer id) {
        return obraLocalizacaoService
                .obterObraLocalizacao(id)
                .orElseThrow(() -> new RegraNegocioException(
                        "Detalhe tecnico não encontrado. " +
                                "Por favor, verifique os campos obrigatorios e tente novamente. "));
    }

    @GetMapping
    public List<ObraLocalizacao> find(ObraLocalizacaoDTO filtro) {
        ExampleMatcher encontrar = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example exemplo = Example.of(filtro, encontrar);
        return obraLocalizacaoRepository.findAll(exemplo);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ObraLocalizacao save(@RequestBody ObraLocalizacaoDTO obraLocalizacaoDTO) {
        return obraLocalizacaoService.salvar(obraLocalizacaoDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        obraLocalizacaoRepository.findById(id)
                .map(ObraLocalizacao -> {
                    obraLocalizacaoRepository.delete(ObraLocalizacao);
                    return Void.TYPE;
                }).orElseThrow(
                        () -> new RegraNegocioException("Localização não encontrada. " +
                                "Por favor, verifique os campos obrigatorios e tente novamente. "));
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id,
            @RequestBody @Validated ObraLocalizacao obraLocalizacao) {
        obraLocalizacaoService.atualizaObraLocalizacao(id, obraLocalizacao);
    }
}
