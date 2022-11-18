package com.obra.obras.service;

import java.util.Optional;

//import org.springframework.stereotype.Service;

import com.obra.obras.domain.entity.ObraDetalhesTecnicos;
//import com.obra.obras.rest.dto.ObraDetalhesTecnicosDTO;

public interface ObraDetalhesTecnicosService {

    ObraDetalhesTecnicos salvar(ObraDetalhesTecnicos obraDetalhesTecnicos);

    Optional<ObraDetalhesTecnicos> obterObraDetalhesTecnicos(Integer id);

    Optional<ObraDetalhesTecnicos> atualizaObraDetalhesTecnicos(Integer id, ObraDetalhesTecnicos obraDetalhesTecnicos);

}
