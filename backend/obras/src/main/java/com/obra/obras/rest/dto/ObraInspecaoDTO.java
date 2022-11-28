package com.obra.obras.rest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.obra.obras.domain.entity.Obra;
import com.obra.obras.domain.enums.InspecaoFrequenciaEnum;
import com.obra.obras.domain.enums.InspecaoStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraInspecaoDTO {
    
    @NotEmpty(message = "Campo id é obrigatorio")
    @NotNull(message = "Campo id é obrigatorio")
    private Integer id;
    @NotEmpty(message = "Campo obraId é obrigatorio")
    @NotNull(message = "Campo obraId é obrigatorio")
    private Obra obraId;
    @NotEmpty(message = "Campo frequencia é obrigatorio")
    @NotNull(message = "Campo frequencia é obrigatorio")
    private InspecaoFrequenciaEnum frequencia;
    @NotEmpty(message = "Campo mes é obrigatorio")
    @NotNull(message = "Campo mes é obrigatorio")
    private Integer mes;
    @NotEmpty(message = "Campo status é obrigatorio")
    @NotNull(message = "Campo status é obrigatorio")
    private InspecaoStatusEnum status;
    @NotEmpty(message = "Campo prioridade é obrigatorio")
    @NotNull(message = "Campo prioridade é obrigatorio")
    private Integer prioridade;
}
