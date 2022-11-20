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

    @NotEmpty(message = "Campo nome é obrigatorio.")
    @NotNull(message = "Campo nome é obrigatorio.")
    private String nome;

    @NotNull(message = "Campo Ano Construção não pode ser vazio.")
    private BigInteger anoConstrucao;

    @NotEmpty(message = "Campo coordenação é obrigatorio.")
    @NotNull(message = "Campo coordenação é obrigatorio.")
    private String coordenacao;

    @NotEmpty(message = "Campo gerencia é obrigatorio.")
    @NotNull(message = "Campo gerencia é obrigatorio.")
    private String gerencia;

    @NotEmpty(message = "Campo diretoria é obrigatorio.")
    @NotNull(message = "Campo diretoria é obrigatorio.")
    private String diretoria;

    @NotEmpty(message = "Campo outorga é obrigatorio.")
    @NotNull(message = "Campo outorga é obrigatorio.")
    private String outorga;

    @NotEmpty(message = "Campo titularidade é obrigatorio.")
    @NotNull(message = "Campo titularidade é obrigatorio.")
    private String titularidade;

}
