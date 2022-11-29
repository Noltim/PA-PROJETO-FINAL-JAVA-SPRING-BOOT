package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.Obra;
import com.obra.obras.domain.repository.ObraRepository;
import com.obra.obras.exception.RegraNegocioException;
import com.obra.obras.rest.dto.ObraDTO;
import com.obra.obras.service.ObraService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/obras")
public class ObraController {

    private ObraRepository obraRepository;
    private ObraService obraService;

    public ObraController(ObraRepository obraRepository, ObraService obraService) {
        this.obraRepository = obraRepository;
        this.obraService = obraService;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(OK)
    public Obra getObraById(@PathVariable Integer id) {
        return obraService.obterObra(id)
                .orElseThrow(() -> new RegraNegocioException("Obra não encontrada. " +
                        "Por favor, verifique os campos obrigatorios e tente novamente. "));

    }

    @GetMapping
    public List<Obra> find(ObraDTO filtro) {
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
    public Obra save(@RequestBody @Validated ObraDTO obraDTO) {
        Obra obra = obraService.salvar(obraDTO);
        return obra;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        obraRepository.findById(id)
                .map(obra -> {
                    obraRepository.delete(obra);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new RegraNegocioException("Obra não encontrada. " +
                        "Por favor, verifique os campos obrigatorios e tente novamente. "));
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id,
            @RequestBody @Validated Obra obra) {
        obraService.atualizaObra(id, obra);

    }

}
