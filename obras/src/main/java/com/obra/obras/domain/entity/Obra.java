package com.obra.obras.domain.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

//modelo
@Entity
@Table(name = "obra")
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    //no banco anoCconstrucao ta passando como ano_construcao
    private Integer anoConstrucao;
    private String coordenacao;
    private String gerencia;
    private String diretoria;
    private String outorga;
    private String titularidade;

    //ligações para busca
    //verificar com o professor isso
    @OneToMany
    private Set<ObraLocalizacao> obrasLocalizacoes;

    @OneToMany(mappedBy = "obraId")
    private Set<ObraDetalhesTecnicos> obraDetalhesTecnicos;

    @OneToOne(mappedBy = "obraId")
    private ObraInspecao obraInspecoes;


    public Set<ObraLocalizacao> getObrasLocalizacoes() {
        return obrasLocalizacoes;
    }

    public void setObrasLocalizacoes(Set<ObraLocalizacao> obrasLocalizacoes) {
        this.obrasLocalizacoes = obrasLocalizacoes;
    }

    public Set<ObraDetalhesTecnicos> getObraDetalhesTecnicos() {
        return obraDetalhesTecnicos;
    }

    public void setObraDetalhesTecnicos(Set<ObraDetalhesTecnicos> obraDetalhesTecnicos) {
        this.obraDetalhesTecnicos = obraDetalhesTecnicos;
    }

    public ObraInspecao getObraInspecoes() {
        return obraInspecoes;
    }

    public void setObraInspecoes(ObraInspecao obraInspecoes) {
        this.obraInspecoes = obraInspecoes;
    }

//até aqui


    //construtores


    public Obra() {
    }

    public Obra(String nome) {
        this.nome = nome;
    }

    public Obra(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Obra(String nome, Integer anoConstrucao, String coordenacao, String gerencia, String diretoria, String outorga, String titularidade) {
        this.nome = nome;
        this.anoConstrucao = anoConstrucao;
        this.coordenacao = coordenacao;
        this.gerencia = gerencia;
        this.diretoria = diretoria;
        this.outorga = outorga;
        this.titularidade = titularidade;
    }

    //get e sets
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoConstrucao() {
        return anoConstrucao;
    }

    public void setAnoConstrucao(Integer anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }

    public String getCoordenacao() {
        return coordenacao;
    }

    public void setCoordenacao(String coordenacao) {
        this.coordenacao = coordenacao;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getDiretoria() {
        return diretoria;
    }

    public void setDiretoria(String diretoria) {
        this.diretoria = diretoria;
    }

    public String getOutorga() {
        return outorga;
    }

    public void setOutorga(String outorga) {
        this.outorga = outorga;
    }

    public String getTitularidade() {
        return titularidade;
    }

    public void setTitularidade(String titularidade) {
        this.titularidade = titularidade;
    }

    //vamos usar para imprimir
    @Override
    public String toString() {
        return "Obra{" + "id=" + id + ", nome='" + nome + '\'' + ", anoConstrucao=" + anoConstrucao + ", coordenacao='" + coordenacao + '\'' + ", gerencia='" + gerencia + '\'' + ", diretoria='" + diretoria + '\'' + ", outorga='" + outorga + '\'' + ", titularidade='" + titularidade + '\'' + '}';
    }
}
