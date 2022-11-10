package com.obra.obras.service;

import com.obra.obras.domain.entity.Obra;
import com.obra.obras.rest.dto.ObraDTO;

public interface ObraService {
    Obra salvar(ObraDTO obraDTO);
}
