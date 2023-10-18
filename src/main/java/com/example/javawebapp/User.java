package com.example.javawebapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class User {
    private int id;
    private String telefone;
    private String email;
    private String senha;

    public boolean checkEmail(){
            if(this.email.length() > 9 && this.email.contains("@"))
            {
                String finalEmail = this.email.split("@")[1];
                if(finalEmail.contains(".") && finalEmail.length() > 3 ){
                    if(finalEmail.charAt(0) != '.' && finalEmail.charAt(finalEmail.length() - 1) != '.'){
                        return true;
                    }
                } 
            }
            return false;
    }

    public static String logar(String email, String senha){
        String error = "";
        if(!checkEmail(email)){
             error = "Email inválido!;";
        }
        
        error += checkSenha(senha); //Retorna os erros específicos da senha
        
        //TO-DO ir buscar no banco um usuário com estes dados
        if(error.isBlank()){
            return null;
        }else{
            return error;
        }
    }

    public static boolean checkEmail(String email){
            if(email.length() > 9 && email.contains("@"))
            {
                String finalEmail = email.split("@")[1];
                if(finalEmail.contains(".") && finalEmail.length() > 3 ){
                    if(finalEmail.charAt(0) != '.' && finalEmail.charAt(finalEmail.length() - 1) != '.'){
                        return true;
                    }
                } 
            }
            return false;
    }

    public static String checkSenha(String senha){
        String errors = " ";
        if (senha.length() < 8) {
            errors += "A senha não tem 8 carácteres de tamanho;";
        }
        if(senha.length() > 16){
            errors += "A senha tem mais de 16 carácteres de tamanho;";
        }

        Pattern lowercasePattern = Pattern.compile("[a-z]");
        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Pattern specialCharPattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");

        Matcher lowercaseMatcher = lowercasePattern.matcher(senha);
        Matcher uppercaseMatcher = uppercasePattern.matcher(senha);
        Matcher specialCharMatcher = specialCharPattern.matcher(senha);

        if (!lowercaseMatcher.find()) {
            errors += "A senha não contém ao menos uma letra minúscula!;";
        }
        if(!uppercaseMatcher.find()){
            errors += "A senha não contém ao menos uma letra maiúscula!;";
        }
        if(!specialCharMatcher.find()){
            errors += "A senha não contém ao menos um carácter especial!;";
        }

        return errors;
    }

    public boolean checkSenha(){
        
        if (this.senha.length() < 8 || this.senha.length() > 32) {
            return false;
        }

        Pattern lowercasePattern = Pattern.compile("[a-z]");
        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Pattern specialCharPattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");

        Matcher lowercaseMatcher = lowercasePattern.matcher(this.senha);
        Matcher uppercaseMatcher = uppercasePattern.matcher(this.senha);
        Matcher specialCharMatcher = specialCharPattern.matcher(this.senha);

        if (!lowercaseMatcher.find() || !uppercaseMatcher.find() || !specialCharMatcher.find()) {
            return false;
        }

        return true;
    }
    
    public User(String telefone, String email, String senha) {
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
