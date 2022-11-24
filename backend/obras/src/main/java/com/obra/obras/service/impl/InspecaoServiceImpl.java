package com.obra.obras.service.impl;

import java.util.Optional;

//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obra.obras.domain.entity.Inspecao;
import com.obra.obras.domain.repository.InspecaoRepository;
import com.obra.obras.exception.RegraNegocioException;
import com.obra.obras.service.InspecaoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class InspecaoServiceImpl implements InspecaoService {

    private final InspecaoRepository inspecaoRepository;

    @Override
    @Transactional
    public Inspecao salvar(Inspecao inspecao) {

        Inspecao inspecaoNovo = new Inspecao();
        inspecaoNovo.setObraInspecaoId(inspecao.getObraInspecaoId());
        inspecaoNovo.setData(inspecao.getData());
        inspecaoNovo.setObservacoes(inspecao.getObservacoes());

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
