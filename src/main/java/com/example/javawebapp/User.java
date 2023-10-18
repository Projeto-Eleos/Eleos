package com.example.javawebapp;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class User {
    private int id;
    private String telefone;
    private String email;
    private String senha;

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

    public static String checkSenha(String senha) {
        StringBuilder errors = new StringBuilder();
    
        if (senha.length() < 8) {
            errors.append("A senha não tem 8 caracteres de tamanho!;");
        }
    
        if (senha.length() > 16) {
            errors.append("A senha tem mais de 16 caracteres de tamanho!;");
        }
    
        Pattern lowercasePattern = Pattern.compile("[a-z]");
        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Pattern specialCharPattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
    
        Matcher lowercaseMatcher = lowercasePattern.matcher(senha);
        Matcher uppercaseMatcher = uppercasePattern.matcher(senha);
        Matcher specialCharMatcher = specialCharPattern.matcher(senha);
    
        if (!lowercaseMatcher.find()) {
            errors.append("A senha não contém ao menos uma letra minúscula!;");
        }
        
        if (!uppercaseMatcher.find()) {
            errors.append("A senha não contém ao menos uma letra maiúscula!;");
        }
        
        if (!specialCharMatcher.find()) {
            errors.append("A senha não contém ao menos um caractere especial!;");
        }
    
        return errors.toString();
    }

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
    
    public static String formatErrors(List<String> campos, String isNull) {
    if (!isNull.isBlank()) {
        String[] camposNulos = isNull.split(";");
        StringBuilder camposNulosCorretos = new StringBuilder();

        for (String campoNulo : camposNulos) {
            int numCampo = Integer.parseInt(campoNulo.replaceAll("[^0-9]", ""));
            String campoCorrespondente = campos.get(numCampo - 1);
            camposNulosCorretos.append(String.format("Campo %s está nulo;", campoCorrespondente));
        }

        return camposNulosCorretos.toString();
    }

    return "";
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
