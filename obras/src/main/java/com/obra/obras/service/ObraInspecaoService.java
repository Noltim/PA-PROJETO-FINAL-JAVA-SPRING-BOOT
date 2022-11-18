package com.obra.obras.service;

import java.util.Optional;

import com.obra.obras.domain.entity.ObraInspecao;

//import org.springframework.stereotype.Service;

public interface ObraInspecaoService {

    ObraInspecao salvar(ObraInspecao obraInspecao);

    Optional<ObraInspecao> obterObraInspecao(Integer id);

    Optional<ObraInspecao> atualizaObraInspecao(Integer id, ObraInspecao obraInspecao);
}
