package com.example.javawebapp.Entity;

import java.util.Date;

public class Donor extends User{

    private String name;
    private String sobrenome;
    private String cpf;
    private boolean adm;
    private Date dataNascimento;
    
    public Donor(int id, String telefone, String email, String senha, String name, String sobrenome, String cpf, boolean adm, Date dataNascimento) {
        super(id, telefone, email, senha); 
        this.name = name;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.adm = adm;
        this.dataNascimento = dataNascimento;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
        
    
}
