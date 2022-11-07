package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.Obra;
import com.obra.obras.domain.repository.Obras;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ObraController {

    private Obras obras;

    public ObraController(Obras obras) {
        this.obras = obras;
    }

    @GetMapping(value = "/api/obras/{id}")
    @ResponseBody
    public ResponseEntity getObraById(@PathVariable Integer id) {
        Optional<Obra> obra = obras.findById(id);
        if (obra.isPresent()) {
            return ResponseEntity.ok(obra.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/api/obras")
    @ResponseBody
    public ResponseEntity<List<Obra>> getAll() {
        return new ResponseEntity<>(obras.findAll(), HttpStatus.OK);
    }

    @PostMapping("/api/obras")
    @ResponseBody
    public ResponseEntity save(@RequestBody Obra obra) {
        Obra obraSalva = obras.save(obra);
        return ResponseEntity.ok(obraSalva);
    }

    @DeleteMapping("/api/obras/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Obra> obra = obras.findById(id);
        if (obra.isPresent()) {
            obras.delete(obra.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/api/obras/{id}")
    @ResponseBody
    public ResponseBody update(@PathVariable Integer id,
                               @RequestBody Obra obra){
        return (ResponseBody) obras
                .findById(id)
                .map(obraExistente -> {
                    obra.setId(obraExistente.getId());
                    obra.setNome(obraExistente.getNome());
                    obra.setAnoConstrucao(obraExistente.getAnoConstrucao());
                    obra.setCoordenacao(obraExistente.getCoordenacao());
                    obra.setGerencia(obraExistente.getGerencia());
                    obra.setDiretoria(obraExistente.getDiretoria());
                    obra.setOutorga(obraExistente.getOutorga());
                    obra.setTitularidade(obraExistente.getTitularidade());
                    obras.save(obra);
                    return ResponseEntity.noContent().build();
                }).orElseGet( () -> ResponseEntity.notFound().build() );
    }
}




