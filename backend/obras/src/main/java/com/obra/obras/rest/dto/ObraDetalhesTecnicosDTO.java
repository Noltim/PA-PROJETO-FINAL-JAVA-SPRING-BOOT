package com.obra.obras.rest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.obra.obras.domain.entity.Obra;
import com.obra.obras.domain.enums.ObraRiscoEnum;
import com.obra.obras.domain.enums.ObraTipoEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraDetalhesTecnicosDTO {

    @NotEmpty(message = "Campo id é obrigatorio")
    @NotNull(message = "Campo id é obrigatorio")
    private Integer id;
    @NotEmpty(message = "Campo obraId é obrigatorio")
    @NotNull(message = "Campo obraId é obrigatorio")
    private Obra obraId;
    @NotEmpty(message = "Campo tipo é obrigatorio")
    @NotNull(message = "Campo tipo é obrigatorio")
    private ObraTipoEnum tipo;
    @NotEmpty(message = "Campo risco é obrigatorio")
    @NotNull(message = "Campo risco é obrigatorio")
    private ObraRiscoEnum risco;
}
