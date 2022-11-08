package com.obra.obras.rest.controller;

import com.obra.obras.domain.entity.ObraInspecao;
import com.obra.obras.domain.repository.ObraInspecaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/obrainspecoes")
public class ObraInspecaoController {


    private ObraInspecaoRepository obraInspecaoRepository;

    public ObraInspecaoController(ObraInspecaoRepository obraInspecaoRepository) {
        this.obraInspecaoRepository = obraInspecaoRepository;
    }

    @GetMapping(value = "{id}")
   public ResponseEntity getObrasInspecoesById(@PathVariable Integer id) {
       Optional<ObraInspecao> obraInspecao = obraInspecaoRepository.findById(id);
        if(obraInspecao.isPresent()){
            return ResponseEntity.ok(obraInspecao.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ObraInspecao>> getAll() {
       return new ResponseEntity<>(obraInspecaoRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ObraInspecao obraInspecao){
        ObraInspecao obraInspecaoSalva = obraInspecaoRepository.save(obraInspecao);
        return ResponseEntity.ok(obraInspecaoSalva);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<ObraInspecao> obraInspecao = obraInspecaoRepository.findById(id);
        if(obraInspecao.isPresent()){
            obraInspecaoRepository.delete(obraInspecao.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
