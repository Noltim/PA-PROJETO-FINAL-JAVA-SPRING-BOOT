package com.obra.obras.service.impl;

import java.util.Optional;

//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obra.obras.domain.entity.Inspecao;
import com.obra.obras.domain.repository.InspecaoRepository;
import com.obra.obras.exception.RegraNegocioException;
import com.obra.obras.rest.dto.InspecaoDTO;
import com.obra.obras.service.InspecaoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class InspecaoServiceImpl implements InspecaoService {

    private final InspecaoRepository inspecaoRepository;

    @Override
    @Transactional
    public Inspecao salvar(InspecaoDTO inspecaoDTO) {

        Inspecao inspecaoNovo = new Inspecao();
        inspecaoNovo.setObraInspecaoId(inspecaoDTO.getObraInspecaoId());
        inspecaoNovo.setData(inspecaoDTO.getData());
        inspecaoNovo.setObservacoes(inspecaoDTO.getObservacoes());

        return inspecaoRepository.save(inspecaoNovo);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Inspecao> obterInspecao(@PathVariable Integer id) {
        return inspecaoRepository.findById(id);
    }

    @Override
    public Optional<Inspecao> atualizaInspecao(Integer id,
            Inspecao inspecao) {
        inspecaoRepository.findById(id)
                .map(inspecaoExistente -> {
                    inspecao.setId(inspecaoExistente.getId());
                    inspecaoRepository.save(inspecao);
                    return inspecaoExistente;
                }).orElseThrow(() -> new RegraNegocioException(" Inspecao não encontrada. " +
                        "Por favor, verifique os campos obrigatorios e tente novamente. "));

        return null;
    }
}
