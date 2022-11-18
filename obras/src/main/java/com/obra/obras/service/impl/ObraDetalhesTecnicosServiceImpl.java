package com.obra.obras.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.obra.obras.domain.entity.ObraDetalhesTecnicos;
import com.obra.obras.domain.repository.ObraDetalhesTecnicosRepository;
//import com.obra.obras.domain.repository.ObraRepository;
import com.obra.obras.exception.RegraNegocioException;
//import com.obra.obras.rest.dto.ObraDetalhesTecnicosDTO;
import com.obra.obras.service.ObraDetalhesTecnicosService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObraDetalhesTecnicosServiceImpl implements ObraDetalhesTecnicosService {

    private final ObraDetalhesTecnicosRepository obraDetalhesTecnicosRepository;

    @Override
    @Transactional
    public ObraDetalhesTecnicos salvar(ObraDetalhesTecnicos obraDetalhesTecnicos) {

        ObraDetalhesTecnicos obraDetalhesTecnicosNovo = new ObraDetalhesTecnicos();
        obraDetalhesTecnicosNovo.setObraId(obraDetalhesTecnicos.getObraId());
        obraDetalhesTecnicosNovo.setRisco(obraDetalhesTecnicos.getRisco());
        obraDetalhesTecnicosNovo.setTipo(obraDetalhesTecnicos.getTipo());

        return obraDetalhesTecnicosRepository.save(obraDetalhesTecnicosNovo);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ObraDetalhesTecnicos> obterObraDetalhesTecnicos(@PathVariable Integer id) {
        return obraDetalhesTecnicosRepository.findById(id);
    }

    @Override
    public Optional<ObraDetalhesTecnicos> atualizaObraDetalhesTecnicos(Integer id,
            ObraDetalhesTecnicos obraDetalhesTecnicos) {

        obraDetalhesTecnicosRepository.findById(id)
                .map(obraDetalhesTecnicosExistente -> {
                    obraDetalhesTecnicos.setId(obraDetalhesTecnicosExistente.getId());
                    obraDetalhesTecnicosRepository.save(obraDetalhesTecnicos);
                    return obraDetalhesTecnicosExistente;
                }).orElseThrow(() -> new RegraNegocioException("Detalhes tecnicos não encontrados. " +
                        "Por favor, verifique os campos obrigatorios e tente novamente. "));
        return null;
    }

}
