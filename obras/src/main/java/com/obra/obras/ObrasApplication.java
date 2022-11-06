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
            @Autowired Obras obras,
            @Autowired Inspecoes inspecoes,
            @Autowired ObraDetalhesTecnicosRep obraDetalhesTecnicosRep,
            @Autowired ObraInspecoes obraInspecoes,
            @Autowired ObraLocalizacoes obraLocalizacoes
    ) {
        return args -> {
            Obra voz = new Obra(null, "Voz de Veludo");
            obras.save(voz);

            ObraDetalhesTecnicos det = new ObraDetalhesTecnicos();
            det.setObraId(voz);
            obraDetalhesTecnicosRep.save(det);

            ObraInspecao o = new ObraInspecao();
            o.setObraId(voz);
            obraInspecoes.save(o);

            Inspecao bugiganga = new Inspecao(null, null, LocalDate.now(), null);
            bugiganga.setObraInspecaoId(o);
            inspecoes.save(bugiganga);

            ObraLocalizacao p = new ObraLocalizacao();
            p.setObraId(voz);
            obraLocalizacoes.save(p);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ObrasApplication.class, args);
    }

}
