package com.obra.obras.service;

import java.util.Optional;

import com.obra.obras.domain.entity.Inspecao;

//import org.springframework.stereotype.Service;

public interface InspecaoService {

    Inspecao salvar(Inspecao inspecao);

    Optional<Inspecao> obterInspecao(Integer id);

    Optional<Inspecao> atualizaInspecao(Integer id, Inspecao inspecao);
}
