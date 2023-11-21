package com.example.javawebapp.forms;

import java.util.Date;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class AddCampaignForm {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;

    @Positive
    private int meta;
    @NotBlank
    private String tipo;
    @NotBlank
    private String categoria;
    @Future
    private Date vencimento;

    public AddCampaignForm(@NotBlank String titulo, @NotBlank String descricao, @Positive int meta,
            @NotBlank String tipo, @NotBlank String categoria, @Future Date vencimento){
        this.titulo = titulo;
        this.descricao = descricao;
        this.meta = meta;
        this.tipo = tipo;
        this.categoria = categoria;
        this.vencimento = vencimento;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getMeta() {
        return meta;
    }
    public void setMeta(int meta) {
        this.meta = meta;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Date getVencimento() {
        return vencimento;
    }
    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    
}
