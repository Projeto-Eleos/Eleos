package com.example.javawebapp;

import java.util.Date;
import java.util.List;
import java.util.Arrays;
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

    public static Object signUpDonor(String telefone, String email, String senha, String name, String sobrenome, String cpf, boolean adm, Date dataNascimento, String confirmSenha) {
        RestricWords validation = new RestricWords();
        StringBuilder error = new StringBuilder();
        
        String isNull = fieldIsNull(telefone, email, senha, name, sobrenome, cpf, adm, dataNascimento, confirmSenha);

        if (!isNull.isBlank()) {
            List<String> campos = Arrays.asList("telefone", "email", "senha", "name", "sobrenome", "cpf", "adm", "dataNascimento", "confirmSenha");
            String mensagemErro = formatErrors(campos, isNull);
            if (mensagemErro.isEmpty()){
                return mensagemErro;
            }
        }
        if (!checkEmail(email)) {
            error.append("Email inválido!;");
        }
    
        error.append(checkSenha(senha)); // Retorna os erros específicos da senha
    
        if (!senha.equals(confirmSenha)) {
            error.append("As senhas não coincidem!;");
        }
    
        if (!validation.checkWords(name)) {
            error.append("Nome contém palavras restritas!;");
        }
    
        if (!validation.checkWords(sobrenome)) {
            error.append("Sobrenome contém palavras restritas!;");
        }
    
        if (!checkCPF(cpf)) {
            error.append("CPF inválido!;");
        }
    
        if (!telefone.matches("^\\(\\d{2}\\)\\ \\d+$")) {
            if (!(telefone.matches("[0-9]+") || telefone.length() == 11 || telefone.length() == 10)) {
                error.append("Telefone inválido, insira apenas números!;");
            } else {
                telefone = telefone.replaceAll("\\(", "");
                telefone = telefone.replaceAll("\\)", "");
                telefone = telefone.replaceAll(" ", "");
            }
        }
    
        error.append(checkDate(dataNascimento));
    
        if (error.length() == 0) {
            return new Donor(telefone, email, senha, name, sobrenome, cpf, adm, dataNascimento);
        } else {
            return error.toString();
        }
    }

    public static boolean checkCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", ""); // Remove pontos e traços, se houver

        if (cpf.length() != 11) {
            return false; // O CPF deve ter 11 dígitos
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false; // Todos os dígitos iguais
        }

        int dig1 = calculateDigit(cpf, 10, 9);
        int dig2 = calculateDigit(cpf, 11, 10);

        String cpfCalculado = String.valueOf(dig1) + String.valueOf(dig2);

        return cpfCalculado.equals(cpf.substring(9));
    }

    private static int calculateDigit(String cpf, int fator, int iteracoes) {
        int soma = 0;
        for (int i = 0; i < iteracoes; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            soma += digito * fator;
            fator--;
        }
        int digito = (soma * 10) % 11;
        return (digito < 10) ? digito : 0;
    }

    public static String checkDate(Date dataNascimento) {
        StringBuilder errors = new StringBuilder();
    
        if (dataNascimento == null) {
            errors.append("Data de nascimento nula!;");
        } else {
            Calendar today = Calendar.getInstance();
            Calendar max = Calendar.getInstance();
            Calendar min = Calendar.getInstance();
    
            today.setTime(new Date());
            max.set(today.get(Calendar.YEAR) - 124, today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
            min.set(today.get(Calendar.YEAR) - 18, today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
    
            Calendar dataNascimentoCalendar = Calendar.getInstance();
            dataNascimentoCalendar.setTime(dataNascimento);
    
            if (!dataNascimentoCalendar.after(max)) {
                errors.append("Verifique o ano de nascimento! Se você tem mais de 124 anos e deseja ser um doador entre em contato conosco!;");
            }
            if (!dataNascimentoCalendar.before(min)) {
                errors.append("Você precisa ter ao menos 18 anos para se cadastrar!;");
            }
        }
    
        return errors.toString();
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
