package com.obra.obras.domain.entity;


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

    @OneToMany(mappedBy = "obraInspecaoId")
    private Set<Inspecao> inspecoes;
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
