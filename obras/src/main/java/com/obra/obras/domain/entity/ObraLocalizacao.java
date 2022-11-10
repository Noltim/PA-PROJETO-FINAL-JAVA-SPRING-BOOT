package com.obra.obras.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraLocalizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cidade;
    @OneToOne
    @JoinColumn(name = "obra_id", referencedColumnName = "id")
    private Obra obraId;
    private String estado;
    private String latitude;
    private String longitude;

}
