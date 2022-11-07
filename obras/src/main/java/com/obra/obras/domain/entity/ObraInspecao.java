package com.obra.obras.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
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


    public ObraInspecao() {
    }

    public ObraInspecao(Integer id, Obra obraId, String frequencia, int mes, String status, int prioridade, Set<Inspecao> inspecoes) {
        this.id = id;
        this.obraId = obraId;
        this.frequencia = frequencia;
        this.mes = mes;
        this.status = status;
        this.prioridade = prioridade;
        this.inspecoes = inspecoes;
    }

    public Set<Inspecao> getInspecoes() {
        return inspecoes;
    }

    public void setInspecoes(Set<Inspecao> inspecoes) {
        this.inspecoes = inspecoes;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Obra getObraId() {
        return obraId;
    }

    public void setObraId(Obra obraId) {
        this.obraId = obraId;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}
