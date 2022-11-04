package com.obra.obras;


import com.obra.obras.domain.entity.Obra;
import com.obra.obras.domain.repository.Obras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class ObrasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Obras obras) {
        return args -> {
            System.out.println("Salvando clientes/obras");
//            forma antiga
            Obra obra = new Obra();
            obra.setNome("Reforma no teste");
            obras.save(obra);

            //forma com construtor
            obras.save(new Obra("Reforma da Reforma no teste", 102,"1","2","3","4","5"));

            boolean existe = obras.existsByNome("Reforma no teste");
            System.out.println("Existe um cliente com o nome 'Reforma da'? "+ existe);


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ObrasApplication.class, args);
    }

}
