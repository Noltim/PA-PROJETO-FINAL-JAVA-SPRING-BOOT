package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.ObraDetalhesTecnicos;
import com.obra.obras.domain.repository.ObraDetalhesTecnicosRepository;
import com.obra.obras.exception.RegraNegocioException;
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

    public ObraDetalhesTecnicosController(ObraDetalhesTecnicosRepository obraDetalhesTecnicosRepository, ObraDetalhesTecnicosService obraDetalhesTecnicosService) {
        this.obraDetalhesTecnicosRepository = obraDetalhesTecnicosRepository;
        this.obraDetalhesTecnicosService = obraDetalhesTecnicosService;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(OK)
    /*
     * O tipo de retorno deve ser GetObraDetalhesTecnicosDTO, mas ainda em busca da
     * logica para converter
     */
    public ObraDetalhesTecnicos getDetalhesObraById(@PathVariable Integer id) {
        return obraDetalhesTecnicosService
                .obterObraDetalhesTecnicos(id)
                .orElseThrow(() -> new RegraNegocioException("Detalhes tecnicos não encontrados. " +
                        "Por favor, verifique os campos obrigatorios e tente novamente. "));
    }

    /*
     * Em busca da resolução do erro, precisa ser feita uma conversão entre o tipo
     * obraDetalhesTecnicos para ObraDetalhesTecnicosDTO
     */
    /*
     * private GetObraDetalhesTecnicosDTO converter(ObraDetalhesTecnicos
     * obraDetalhesTecnicos) {
     * return GetObraDetalhesTecnicosDTO
     * .builder()
     * .id(obraDetalhesTecnicos.getId())
     * .obraId(obraDetalhesTecnicos.getObraId())
     * .tipo(obraDetalhesTecnicos.getTipo())
     * .risco(obraDetalhesTecnicos.getRisco())
     * .build();
     * }
     */

    @GetMapping
    /*
     * O tipo de retorno deve ser GetObraDetalhesTecnicosDTO, mas ainda em busca da
     * logica para converter
     */
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
    /*
     * O tipo de retorno deve ser GetObraDetalhesTecnicosDTO, mas ainda em busca da
     * logica para converter
     */
    public ObraDetalhesTecnicos save(@RequestBody ObraDetalhesTecnicos obraDetalhesTecnicos) {
        return obraDetalhesTecnicosService.salvar(obraDetalhesTecnicos);
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
