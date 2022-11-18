package com.obra.obras.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.obra.obras.domain.entity.ObraLocalizacao;
import com.obra.obras.domain.repository.ObraLocalizacaoRepository;
import com.obra.obras.exception.RegraNegocioException;
//import com.obra.obras.rest.dto.ObraLocalizacaoDTO;
import com.obra.obras.service.ObraLocalizacaoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObraLocalizacaoServiceImpl implements ObraLocalizacaoService {

    private final ObraLocalizacaoRepository obraLocalizacaoRepository;

    @Override
    @Transactional
    public ObraLocalizacao salvar(ObraLocalizacao obraLocalizacao) {

        ObraLocalizacao obraLocalizacaoNovo = new ObraLocalizacao();
        obraLocalizacaoNovo.setObraId(obraLocalizacao.getObraId());
        obraLocalizacaoNovo.setCidade(obraLocalizacao.getCidade());
        obraLocalizacaoNovo.setEstado(obraLocalizacao.getEstado());
        obraLocalizacaoNovo.setLatitude(obraLocalizacao.getLatitude());
        obraLocalizacaoNovo.setLongitude(obraLocalizacao.getLongitude());

        return obraLocalizacaoRepository.save(obraLocalizacaoNovo);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ObraLocalizacao> obterObraLocalizacao(@PathVariable Integer id) {
        return obraLocalizacaoRepository.findById(id);
    }

    @Override
    public Optional<ObraLocalizacao> atualizaObraLocalizacao(Integer id,
            ObraLocalizacao obraLocalizacao) {
        obraLocalizacaoRepository.findById(id)
                .map(obraLocalizacaoExistente -> {
                    obraLocalizacao.setId(obraLocalizacaoExistente.getId());
                    obraLocalizacaoRepository.save(obraLocalizacao);
                    return obraLocalizacaoExistente;
                }).orElseThrow(() -> new RegraNegocioException("Detalhes tecnicos não encontrados. " +
                        "Por favor, verifique os campos obrigatorios e tente novamente. "));
        return null;
    }
}
