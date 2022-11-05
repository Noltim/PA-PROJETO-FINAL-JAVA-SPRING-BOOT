package com.obra.obras;


import com.obra.obras.domain.entity.Inspecao;
import com.obra.obras.domain.entity.Obra;
import com.obra.obras.domain.entity.ObraInspecao;
import com.obra.obras.domain.repository.Inspecoes;
import com.obra.obras.domain.repository.ObraInspecoes;
import com.obra.obras.domain.repository.Obras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;


@SpringBootApplication
public class ObrasApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired Obras obras,
            @Autowired ObraInspecoes obrasInpescoes,
            @Autowired Inspecoes inspecoes) {


        return args -> {
            System.out.println("Salvando clientes/obras");
//            forma antiga
            Obra obra = new Obra();
            obra.setNome("Reforma no teste");
            obras.save(obra);

            //molde teste
            Obra Reforma = new Obra("Nova Reforma");
            obras.save(Reforma);

            ObraInspecao insp = new ObraInspecao();
            insp.setObraId(Reforma);

            obrasInpescoes.save(insp);

            Inspecao inspes = new Inspecao();
            inspes.setObraInspecaoId(insp);
            inspes.setData(LocalDate.now());

            inspecoes.save(inspes);

            //forma com construtor
            obras.save(new Obra("Reforma da Reforma no teste", 102, "1", "2", "3", "4", "5"));

            obrasInpescoes.findObraInspecaoFetchInspecoes(Reforma.getId());
            System.out.println(Reforma);
            System.out.println(insp.getInspecoes());
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ObrasApplication.class, args);
    }

}
