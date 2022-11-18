package com.obra.obras.service;

import java.util.Optional;

import com.obra.obras.domain.entity.ObraLocalizacao;
//import com.obra.obras.rest.dto.ObraLocalizacaoDTO;

//import org.springframework.stereotype.Service;

public interface ObraLocalizacaoService {

    ObraLocalizacao salvar(ObraLocalizacao obraLocalizacao);

    Optional<ObraLocalizacao> obterObraLocalizacao(Integer id);

    Optional<ObraLocalizacao> atualizaObraLocalizacao(Integer id, ObraLocalizacao obraLocalizacao);
}
