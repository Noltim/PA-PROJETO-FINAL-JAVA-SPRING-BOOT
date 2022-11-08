package com.obra.obras.service.impl;

import com.obra.obras.domain.repository.ObraRepository;
import com.obra.obras.service.ObraService;
import org.springframework.stereotype.Service;

@Service
public class ObraServiceImpl implements ObraService {

    private ObraRepository obraRepository;

    public ObraServiceImpl(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }
}
