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
	public CommandLineRunner init(@Autowired Obras obras){
		return args -> {
			//forma antiga
			Obra obra = new Obra();
			obra.setNome("Reforma no teste");
			obras.salvar(obra);

			//forma com construtor
			obras.salvar(new Obra("Reforma da Reforma no teste"));

			List<Obra> todosClientes = obras.obterTodos();
			todosClientes.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ObrasApplication.class, args);
	}

}
