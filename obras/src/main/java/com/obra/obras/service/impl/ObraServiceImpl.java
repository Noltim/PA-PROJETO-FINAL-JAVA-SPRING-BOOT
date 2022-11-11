package com.obra.obras.service.impl;

import com.obra.obras.domain.entity.Obra;
import com.obra.obras.domain.repository.ObraRepository;
import com.obra.obras.exception.RegraNegocioException;
import com.obra.obras.rest.dto.ObraDTO;
import com.obra.obras.service.ObraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
