package com.obra.obras.rest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraLocalizacaoDTO {

    @NotEmpty(message = "Campo id é obrigatorio")
    @NotNull(message = "Campo id é obrigatorio")
    private Integer id;
    @NotEmpty(message = "Campo cidade é obrigatorio")
    @NotNull(message = "Campo cidade é obrigatorio")
    private String cidade;
    @NotEmpty(message = "Campo obraId é obrigatorio")
    @NotNull(message = "Campo obraId é obrigatorio")
    private Integer obraId;
    @NotEmpty(message = "Campo estado é obrigatorio")
    @NotNull(message = "Campo estado é obrigatorio")
    private String estado;
    @NotEmpty(message = "Campo latitude é obrigatorio")
    @NotNull(message = "Campo latitude é obrigatorio")
    private String latitude;
    @NotEmpty(message = "Campo longitude é obrigatorio")
    @NotNull(message = "Campo longitude é obrigatorio")
    private String longitude;
}
