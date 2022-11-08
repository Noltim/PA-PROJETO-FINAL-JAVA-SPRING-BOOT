package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.Inspecao;
import com.obra.obras.domain.repository.InspecaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inspecoes")
public class InspecaoController {

    private InspecaoRepository inspecaoRepository;

    public InspecaoController(InspecaoRepository inspecaoRepository){
        this.inspecaoRepository = inspecaoRepository;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getInspecoesById(@PathVariable Integer id) {
        Optional<Inspecao> inspecao = inspecaoRepository.findById(id);
        if(inspecao.isPresent()){
            return ResponseEntity.ok(inspecao.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Inspecao>> getAll() {
        return new ResponseEntity<>(inspecaoRepository.findAll() , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Inspecao inspecao){
        Inspecao inspecaoSalva = inspecaoRepository.save(inspecao);
        return ResponseEntity.ok(inspecaoSalva);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<Inspecao> inspecao = inspecaoRepository.findById(id);
        if(inspecao.isPresent()){
            inspecaoRepository.delete(inspecao.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
