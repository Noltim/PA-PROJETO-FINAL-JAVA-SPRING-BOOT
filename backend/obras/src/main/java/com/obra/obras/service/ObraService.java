package com.obra.obras.service;

import com.obra.obras.domain.entity.Obra;
import com.obra.obras.rest.dto.ObraDTO;

import java.util.Optional;

public interface ObraService {
    Obra salvar(ObraDTO obraDTO);

    Optional<Obra> obterObra(Integer id);

    Optional<Obra> atualizaObra(Integer id, Obra obra);
}
