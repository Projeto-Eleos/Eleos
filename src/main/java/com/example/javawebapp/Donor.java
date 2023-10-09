package com.example.javawebapp;

import java.util.Date;
import java.util.Calendar;

public class Donor extends User{
    private static int ultimoId = 0;

    private String name;
    private String sobrenome;
    private String cpf;
    private boolean adm;
    private Date dataNascimento;

    public Donor(String telefone, String email, String senha, String name, String sobrenome, String cpf, boolean adm, Date dataNascimento) {
        super(telefone, email, senha);
        super.setId(ultimoId + 1); ultimoId++; 
        this.name = name;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.adm = adm;
        this.dataNascimento = dataNascimento;
    }

    public static Object singUpDonnor(String telefone, String email, String senha, String name, String sobrenome, String cpf, boolean adm, Date dataNascimento){
        String error = "";
        if(!checkEmail(email)){
             error = "Email inválido";
        }
        if(!checkSenha(senha)){
            error = "\nSenha inválida!";
        }
        if(!RestricWords.checkWords(name)){
            error = "\nNome contém palavras restritas!";
        }
        if(!RestricWords.checkWords(sobrenome)){
            error = "\nSobrenome contém palavras restritas!";
        }
        if(!RestricWords.checkWords(name)){
            error = "\nSobrenome contém palavras restritas!";
        }
        if(!telefone.matches("^\\([0-9]\\d{2}\\)\\d+$")){
            if(!telefone.matches("[0-9]+")){
                error = "\nTelefóne inválido, insira apenas números!";
            }else{
                telefone = telefone.replaceAll("(", "");
                telefone = telefone.replaceAll(")", "");
            }
        }
        if(!checkDate(dataNascimento)){
            error = "\nData inválida!";
        }
        if(error.isBlank()){
            return new Donor(telefone, email, senha, name, sobrenome, cpf, adm, dataNascimento);
        }else{
            return error;
        }
    }
    
    public boolean checkDate(){
        Calendar today = Calendar.getInstance(); today.setTime(new Date());
        if(today.before(dataNascimento)){
           return false; 
        } 
        Calendar max = Calendar.getInstance();
        max.add(max.get(Calendar.YEAR), -124);
        Calendar min = Calendar.getInstance();
        min.add(min.get(Calendar.YEAR), -18);
        if(min.before(dataNascimento) || max.after(dataNascimento)){
            return true;
        }
        return false;
    }

    public static boolean checkDate(Date dataNascimento){
        Calendar today = Calendar.getInstance(); today.setTime(new Date());
        if(today.before(dataNascimento)){
           return false; 
        } 
        Calendar max = Calendar.getInstance();
        max.add(max.get(Calendar.YEAR), -124);
        Calendar min = Calendar.getInstance();
        min.add(min.get(Calendar.YEAR), -18);
        if(min.before(dataNascimento) || max.after(dataNascimento)){
            return true;
        }
        return false;
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
