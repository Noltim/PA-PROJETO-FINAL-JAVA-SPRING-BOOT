package com.obra.obras.rest.dto;

import com.obra.obras.domain.entity.Obra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetObraDetalhesTecnicosDTO {
    
    private Integer id;
    private Integer obraId;
    private String tipo;
    private String risco;
}
