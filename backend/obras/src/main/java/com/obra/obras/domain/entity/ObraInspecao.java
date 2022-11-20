package com.obra.obras.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.obra.obras.domain.enums.InspecaoFrequenciaEnum;
import com.obra.obras.domain.enums.InspecaoStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraInspecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "obra_id", referencedColumnName="id")
    private Obra obraId;
    @Enumerated(EnumType.STRING)
    private InspecaoFrequenciaEnum frequencia;
    private Integer mes;
    @Enumerated(EnumType.STRING)
    private InspecaoStatusEnum status;
    private Integer prioridade;

    @JsonIgnore
    @OneToMany(mappedBy = "obraInspecaoId", fetch = FetchType.LAZY)
    private Set<Inspecao> inspecoes;




}
