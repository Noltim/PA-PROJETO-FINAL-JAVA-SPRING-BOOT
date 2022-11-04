package com.obra.obras.domain.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Inspecao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private ObraInspecao obraInspecaoId;
    private LocalDate data;
    private String observacoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ObraInspecao getObraInspecaoId() {
        return obraInspecaoId;
    }

    public void setObraInspecaoId(ObraInspecao obraInspecaoId) {
        this.obraInspecaoId = obraInspecaoId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
