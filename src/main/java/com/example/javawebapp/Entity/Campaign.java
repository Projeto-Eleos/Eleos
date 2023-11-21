package com.example.javawebapp.Entity;

import java.util.Date;

public class Campaign {
    private int id;
    private String titulo;
    private Date vencimento;
    private String descricao;
    private Integer meta;
    private String categoria;
    private String tipo;
    private String urlImage;
    private int idDeposito;

    public Campaign(int id, String titulo, Date vencimento, String descricao, Integer meta, String categoria,
            String tipo, String urlImage) {
        this.id = id;
        this.titulo = titulo;
        this.vencimento = vencimento;
        this.descricao = descricao;
        this.meta = meta;
        this.categoria = categoria;
        this.tipo = tipo;
        this.urlImage = urlImage;
        this.idDeposito = 0;
    }
    public Campaign(int id, String titulo, Date vencimento, String descricao, String tipo, int meta, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.vencimento = vencimento;
        this.descricao = descricao;
        this.meta = meta;
        this.categoria = categoria;
        this.tipo = tipo;
        this.idDeposito = 0;
    }
    public Campaign(int id, String titulo, Date vencimento, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.vencimento = vencimento;
        this.descricao = descricao;
        this.idDeposito = 0;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Date getVencimento() {
        return vencimento;
    }
    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getIdDeposito() {
        return idDeposito;
    }
    public void setIdDeposito(int idDeposito) {
        this.idDeposito = idDeposito;
    }
    public Integer getMeta() {
        return meta;
    }
    public void setMeta(Integer meta) {
        this.meta = meta;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getUrlImage() {
        return urlImage;
    }
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
