package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.Obra;
import com.obra.obras.domain.repository.ObraRepository;
import com.obra.obras.exception.RegraNegocioException;
import com.obra.obras.rest.dto.GetObraDTO;
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
    public GetObraDTO getObraByIdDTO(@PathVariable Integer id) {
        return obraService.obterObra(id)
                .map(obra -> converter(obra))
                .orElseThrow(() -> new RegraNegocioException("Obra não encontrada. " +
                        "Por favor, verifique os campos obrigatorios e tente novamente. "));

    }

    private GetObraDTO converter(Obra obra) {
        return GetObraDTO
                .builder()
                .id(obra.getId())
                .nome(obra.getNome())
                .anoConstrucao(obra.getAnoConstrucao())
                .coordenacao(obra.getCoordenacao())
                .gerencia(obra.getGerencia())
                .diretoria(obra.getDiretoria())
                .outorga(obra.getOutorga())
                .titularidade(obra.getTitularidade())
                .build();
    }


    //passar para o DTO
    @GetMapping
    public List<GetObraDTO> find(Obra filtro) {
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

    // colocar para retornar um DTO
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


    //retorna um dto
    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id,
                       @RequestBody @Validated Obra obra) {
        obraService.atualizaObra(id, obra);

    }

}
