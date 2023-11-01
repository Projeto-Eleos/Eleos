package com.example.javawebapp;

public class Organization extends User{
    private static int ultimoId = 0;

    private String razaoSocial;
    private String endereco;
    private String cnpj;

    public Organization(String telefone, String email, String senha, String razaoSocial, String endereco, String cnpj) {
        super(telefone, email, senha);
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
}
