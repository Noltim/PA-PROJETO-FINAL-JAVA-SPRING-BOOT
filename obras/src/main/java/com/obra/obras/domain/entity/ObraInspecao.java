package com.obra.obras.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "obra_id", referencedColumnName="id")
    private Obra obraId;
    private String frequencia;
    private int mes;
    private String status;
    private int prioridade;

    @JsonIgnore
    @OneToMany(mappedBy = "obraInspecaoId", fetch = FetchType.LAZY)
    private Set<Inspecao> inspecoes;


}
