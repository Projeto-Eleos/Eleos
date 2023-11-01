package com.example.javawebapp.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import com.example.javawebapp.forms.ownsvalidations.Phone;
import com.example.javawebapp.forms.ownsvalidations.ValidAdress;
import com.example.javawebapp.forms.ownsvalidations.ValidPassword;

public class SignUpOngForm {
    @NotBlank
    @Phone
    private String telefone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @ValidPassword
    private String senha;

    @NotBlank
    @ValidPassword
    private String coonfirmSenha;

    @NotBlank
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 255 letras")
    @Pattern(regexp = "^[A-Za-z]+$", message = "O nome deve conter apenas letras")
    private String razaoSocial;

    @NotBlank
    @ValidAdress
    private String endereco;

    @NotBlank
    @CNPJ
    private String cnpj;

    public SignUpOngForm(@NotBlank @Phone String telefone, @NotBlank @Email String email, @NotBlank @ValidPassword String senha,
            @NotBlank @ValidPassword String coonfirmSenha,
            @NotBlank @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 255 letras") @Pattern(regexp = "^[A-Za-z]+$", message = "O nome deve conter apenas letras") String razaoSocial,
            @NotBlank @ValidAdress String endereco, @NotBlank @CNPJ String cnpj) {
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.coonfirmSenha = coonfirmSenha;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCoonfirmSenha() {
        return coonfirmSenha;
    }

    public void setCoonfirmSenha(String coonfirmSenha) {
        this.coonfirmSenha = coonfirmSenha;
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
