package com.obra.obras;


import com.obra.obras.domain.entity.*;
import com.obra.obras.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;


@SpringBootApplication
public class ObrasApplication {

    @Bean
    public CommandLineRunner commandLineRunner(
            @Autowired ObraRepository obraRepository,
            @Autowired InspecaoRepository inspecaoRepository,
            @Autowired ObraDetalhesTecnicosRepository obraDetalhesTecnicosRepository,
            @Autowired ObraInspecaoRepository obraInspecaoRepository,
            @Autowired ObraLocalizacaoRepository obraLocalizacaoRepository
    ) {
        return args -> {
            Obra voz = new Obra(null, "Triplex");
            obraRepository.save(voz);

            ObraDetalhesTecnicos det = new ObraDetalhesTecnicos();
            det.setObraId(voz);
            obraDetalhesTecnicosRepository.save(det);

            ObraInspecao o = new ObraInspecao();
            o.setObraId(voz);
            obraInspecaoRepository.save(o);

            Inspecao bugiganga = new Inspecao(null, null, LocalDate.now(), null);
            bugiganga.setObraInspecaoId(o);
            inspecaoRepository.save(bugiganga);

            ObraLocalizacao p = new ObraLocalizacao();
            p.setObraId(voz);
            obraLocalizacaoRepository.save(p);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ObrasApplication.class, args);
    }

}