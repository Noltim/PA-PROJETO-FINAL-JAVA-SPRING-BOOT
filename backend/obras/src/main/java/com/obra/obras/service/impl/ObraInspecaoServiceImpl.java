package com.obra.obras.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.obra.obras.domain.entity.ObraInspecao;
import com.obra.obras.domain.repository.ObraInspecaoRepository;
import com.obra.obras.exception.RegraNegocioException;
import com.obra.obras.service.ObraInspecaoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObraInspecaoServiceImpl implements ObraInspecaoService {

    private final ObraInspecaoRepository obraInspecaoRepository;

    @Override
    @Transactional
    public ObraInspecao salvar(ObraInspecao obraInspecao) {

        ObraInspecao obraInspecaoNovo = new ObraInspecao();
        obraInspecaoNovo.setObraId(obraInspecao.getObraId());
        obraInspecaoNovo.setFrequencia(obraInspecao.getFrequencia());
        obraInspecaoNovo.setMes(obraInspecao.getMes());
        obraInspecaoNovo.setStatus(obraInspecao.getStatus());
        obraInspecaoNovo.setPrioridade(obraInspecao.getPrioridade());

        return obraInspecaoRepository.save(obraInspecaoNovo);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ObraInspecao> obterObraInspecao(@PathVariable Integer id) {
        return obraInspecaoRepository.findById(id);
    }

    @Override
    public Optional<ObraInspecao> atualizaObraInspecao(Integer id,
            ObraInspecao obraInspecao) {

        obraInspecaoRepository.findById(id)
                .map(obraInspecaoExistente -> {
                    obraInspecao.setId(obraInspecaoExistente.getId());
                    obraInspecaoRepository.save(obraInspecao);
                    return obraInspecaoExistente;
                }).orElseThrow(() -> new RegraNegocioException(" Obra Inspecao não encontrados. " +
                        "Por favor, verifique os campos obrigatorios e tente novamente. "));
        return null;
    }

}
