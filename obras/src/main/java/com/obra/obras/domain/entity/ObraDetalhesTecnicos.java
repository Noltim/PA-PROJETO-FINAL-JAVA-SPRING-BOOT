package com.obra.obras.domain.entity;


import javax.persistence.*;

@Entity
public class ObraDetalhesTecnicos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "obra_id", referencedColumnName="id")
    private Obra obraId;
    private String tipo;
    private String risco;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }
}
