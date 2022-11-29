package com.obra.obras.service;

import java.util.Optional;

import com.obra.obras.domain.entity.Inspecao;
import com.obra.obras.rest.dto.InspecaoDTO;

public interface InspecaoService {

    Inspecao salvar(InspecaoDTO inspecaoDTO);

    Optional<Inspecao> obterInspecao(Integer id);

    Optional<Inspecao> atualizaInspecao(Integer id, Inspecao inspecao);
}
