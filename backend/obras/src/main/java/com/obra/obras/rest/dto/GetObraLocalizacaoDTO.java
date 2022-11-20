package com.obra.obras.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetObraLocalizacaoDTO {

    private Integer id;
    private String cidade;
    private Integer obraId;
    private String estado;
    private String latitude;
    private String longitude;
}
