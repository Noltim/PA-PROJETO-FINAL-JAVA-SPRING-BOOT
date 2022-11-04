package com.obra.obras;


import com.obra.obras.domain.entity.Obra;
import com.obra.obras.domain.repository.Obras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ObrasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Obras obras) {
        return args -> {
            System.out.println("Salvando clientes/obras");
            //forma antiga
            Obra obra = new Obra();
            obra.setNome("Reforma no teste");
            obras.salvar(obra);

            //forma com construtor
            obras.salvar(new Obra("Reforma da Reforma no teste"));

            List<Obra> todosClientes = obras.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando clientes/obras");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado");
                obras.atualizar(c);
            });

            todosClientes = obras.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando clientes/obras");
            obras.buscarPorNome("da").forEach(System.out::println);

//            System.out.println("Deletando clientes/obras");
//
//            obras.obterTodos().forEach(c -> {
//                obras.deletar(c);
//            });
//
//            todosClientes = obras.obterTodos();
//            if (todosClientes.isEmpty()) {
//                System.out.println("Nenhuma obra/cliente encontrado!");
//            } else {
//                todosClientes.forEach(System.out::println);
//            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ObrasApplication.class, args);
    }

}
