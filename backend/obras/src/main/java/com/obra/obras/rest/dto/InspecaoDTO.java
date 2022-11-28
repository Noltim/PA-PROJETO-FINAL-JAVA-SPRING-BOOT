package com.obra.obras.rest.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.obra.obras.domain.entity.ObraInspecao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspecaoDTO {

    @NotEmpty(message = "Campo id é obrigatorio")
    @NotNull(message = "Campo id é obrigatorio")
    private Integer id; 
    @NotEmpty(message = "Campo obraInspecaoId é obrigatorio")
    @NotNull(message = "Campo obraInspecaoId é obrigatorio")  
    private ObraInspecao obraInspecaoId;
    @NotEmpty(message = "Campo data é obrigatorio")
    @NotNull(message = "Campo data é obrigatorio")
    private LocalDate data;
    @NotEmpty(message = "Campo observações é obrigatorio")
    @NotNull(message = "Campo observações é obrigatorio")
    private String observacoes;
}
