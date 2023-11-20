package com.example.javawebapp.Entity;

public class Organization extends User{
    
    private String razaoSocial;
    private String endereco;
    private String cnpj;

    public Organization(int id, String telefone, String email, String senha, String razaoSocial, String endereco, String cnpj) {
        super(id, telefone, email, senha);
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
