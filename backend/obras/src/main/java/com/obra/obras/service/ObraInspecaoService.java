package com.obra.obras.service;

import java.util.Optional;

import com.obra.obras.domain.entity.ObraInspecao;
import com.obra.obras.rest.dto.ObraInspecaoDTO;

public interface ObraInspecaoService {

    ObraInspecao salvar(ObraInspecaoDTO obraInspecaoDTO);

    Optional<ObraInspecao> obterObraInspecao(Integer id);

    Optional<ObraInspecao> atualizaObraInspecao(Integer id, ObraInspecao obraInspecao);
}
