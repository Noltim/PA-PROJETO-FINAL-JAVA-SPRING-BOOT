package com.obra.obras.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraDTO {

    @NotEmpty
    @NotNull
    private String nome;

    @NotNull
    private BigInteger anoConstrucao;
    @NotEmpty
    @NotNull
    private String coordenacao;
    @NotEmpty
    @NotNull
    private String gerencia;
    @NotEmpty
    @NotNull
    private String diretoria;
    @NotEmpty
    @NotNull
    private String outorga;
    @NotEmpty
    @NotNull
    private String titularidade;

}
