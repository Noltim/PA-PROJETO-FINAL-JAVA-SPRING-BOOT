package com.obra.obras.service.impl;

import com.obra.obras.domain.entity.Obra;
import com.obra.obras.domain.repository.ObraRepository;
import com.obra.obras.exception.RegraNegocioException;
import com.obra.obras.rest.dto.ObraDTO;
import com.obra.obras.service.ObraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ObraServiceImpl implements ObraService {

    private final ObraRepository obraRepository;

    @Override
    @Transactional
    public Obra salvar(ObraDTO obraDTO) {

        Obra obraNovo = new Obra();
        obraNovo.setNome(obraDTO.getNome());
        obraNovo.setAnoConstrucao(obraDTO.getAnoConstrucao());
        obraNovo.setCoordenacao(obraDTO.getCoordenacao());
        obraNovo.setGerencia(obraDTO.getGerencia());
        obraNovo.setDiretoria(obraDTO.getDiretoria());
        obraNovo.setOutorga(obraDTO.getOutorga());
        obraNovo.setTitularidade(obraDTO.getTitularidade());

        return obraRepository.save(obraNovo);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Obra> obterObra(@PathVariable Integer id) {
        return obraRepository.findById(id);
    }

    @Override
    public Optional<Obra> atualizaObra(Integer id, Obra obra) {

        obraRepository.findById(id)
                .map(obraExistente -> {
                    obra.setId(obraExistente.getId());
                    obraRepository.save(obra);
                    return obraExistente;
                }).orElseThrow(() -> new RegraNegocioException("Obra não encontrada. " +
                        "Por favor, verifique os campos obrigatorios e tente novamente. "));

        return null;
    }
}
