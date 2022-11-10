package com.obra.obras.domain.entity;


import com.obra.obras.domain.enums.ObraRiscoEnum;
import com.obra.obras.domain.enums.ObraTipoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraDetalhesTecnicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "obra_id", referencedColumnName = "id")
    private Obra obraId;
    @Enumerated(EnumType.STRING)
    private ObraTipoEnum tipo;
    @Enumerated(EnumType.STRING)
    private ObraRiscoEnum risco;


}
