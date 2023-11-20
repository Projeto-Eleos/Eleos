package com.example.javawebapp.Entity;

public abstract class User {
    private int id;
    private String telefone;
    private String email;
    private String senha;

    public static String fieldIsNull(Object... args) {
        StringBuilder nulos = new StringBuilder();
        int i = 0;
        for (Object campo : args) {
            i++;
            if (campo == null) {
                nulos.append(String.format("Campo %d é nulo", i));
            }
        }
        return nulos.toString();
    } 

    
    public User(int id, String telefone, String email, String senha) {
        this.id = id;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
