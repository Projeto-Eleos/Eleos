package com.example.javawebapp;

import java.util.Date;
import java.util.HashSet;
import java.util.Calendar;

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

    public static Object singUpOrganization(String telefone, String email, String senha, String razaoSocial, String cnpj, String endereco, String confirmSenha){
        RestricWords validation = new RestricWords();
        String error = "";
        if(!checkEmail(email)){
             error += "Email inválido!;";
        }

        error += checkSenha(senha); //Retorna os erros específicos da senha

        if(!senha.equals(confirmSenha)){
            error += "As senhas não coincidem!;";
        }
        if(!validation.checkWords(razaoSocial)){
            error += "Razão Social contém palavras restritas!;";
        }
        if(!checkAdress(endereco)){
            error += "Endereço inválido!;";
        }
        if(!checkCNPJ(cnpj)){
            error += "CNPJ inválido!;";
        }
        if (!telefone.matches("^\\(\\d{2}\\)\\ \\d+$")) {
            if (!(telefone.matches("[0-9]+") || telefone.length() == 11 || telefone.length() == 10)) {
                error += "Telefone inválido, insira apenas números!;";
            } else {
                telefone = telefone.replaceAll("\\(", "");
                telefone = telefone.replaceAll("\\)", "");
                telefone = telefone.replaceAll(" ", "");
            }
        }        
        if(error.isBlank()){
            return new Organization(telefone, email, senha, razaoSocial, endereco, cnpj);
        }else{
            return error;
        }
    }

    public static boolean checkCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", ""); // Remove pontos/traços/barras, se houver
    
        if (cnpj.length() != 14) {
            return false;
        }
    
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false; // Todos os dígitos iguais
        }
    
        int dig1 = calculateDigit(cnpj, 12);
        int dig2 = calculateDigit(cnpj, 13);
    
        String cnpjCalculado = String.valueOf(dig1) + String.valueOf(dig2);
    
        return cnpjCalculado.equals(cnpj.substring(12));
    }
    
    private static int calculateDigit(String cnpj, int iteracoes) {
        int soma = 0;
        int fator = iteracoes == 12 ? 6 : 5;
        for (int i = 0; i < iteracoes; i++) {
            int digito = Character.getNumericValue(cnpj.charAt(i));
            soma += digito * fator;
            fator = fator >= 9 ? 2 : fator + 1;
        }
        int digito = soma % 11;
        return digito;
    }

    public static boolean checkAdress(String endereco){
        if(endereco.length() < 9){
            return false;
        }

        var palavras = endereco.replaceAll(",", " ").split(" ");
        HashSet<String> viasValidas = getViasValidas();
        for (String palavra : palavras) {
            if(viasValidas.contains(palavra.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    private static java.util.HashSet<String> getViasValidas(){
        HashSet<String> viasValidas = new HashSet<>();
        viasValidas.add("rua");
        viasValidas.add("avenida");
        viasValidas.add("alameda");
        viasValidas.add("estrada");
        viasValidas.add("praça");
        viasValidas.add("quadra");
        viasValidas.add("travessa");
        viasValidas.add("largo");
        viasValidas.add("rodovia");
        viasValidas.add("viaduto");
        viasValidas.add("passagem");
        viasValidas.add("beco");
        viasValidas.add("boulevard");
        viasValidas.add("via");
        viasValidas.add("ladeira");
        viasValidas.add("travessia");
        return viasValidas;
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
