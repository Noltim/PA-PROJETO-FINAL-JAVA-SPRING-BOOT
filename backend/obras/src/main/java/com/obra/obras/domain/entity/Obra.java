package com.obra.obras.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigInteger;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Campo nome é obrigatório")
    private String nome;
    private BigInteger anoConstrucao;
    private String coordenacao;
    private String gerencia;
    private String diretoria;
    private String outorga;
    private String titularidade;

    public Obra(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
}
