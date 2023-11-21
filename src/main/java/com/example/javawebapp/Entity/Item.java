package com.example.javawebapp.Entity;

import java.util.Date;

public class Item {
    private int id;
    private String nome;
    private String quantidade;
    private Boolean novo_usado;
    private Date validade;
    private String tamanho;
    private String estado;
    private String observacao;
    private int idCampanha;

    public Item(int id, String nome, String quantidade, Boolean novo_usado, Date validade, String tamanho,
            String estado, String observacao, int idCampanha) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.novo_usado = novo_usado;
        this.validade = validade;
        this.tamanho = tamanho;
        this.estado = estado;
        this.observacao = observacao;
        this.idCampanha = idCampanha;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    public Boolean getNovo_usado() {
        return novo_usado;
    }
    public void setNovo_usado(Boolean novo_usado) {
        this.novo_usado = novo_usado;
    }
    public Date getValidade() {
        return validade;
    }
    public void setValidade(Date validade) {
        this.validade = validade;
    }
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public int getIdCampanha() {
        return idCampanha;
    }
    public void setIdCampanha(int idCampanha) {
        this.idCampanha = idCampanha;
    }

    

}
