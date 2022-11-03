package com.obra.obras.service;

import com.obra.obras.model.Obra;
import com.obra.obras.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObraService {

    private ObraRepository repository;

    @Autowired
    public ObraService(ObraRepository repository) {
        this.repository = repository;
    }

    public void salvarObra(Obra obra) {
        validarObra(obra);
        this.repository.persistir(obra);
    }

    public void validarObra(Obra obra) {
        //aplica validações
    }
}