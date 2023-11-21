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
    @Phone(message = "O telefone é inválido!")
    @NotBlank(message = "O telefone não pode ser vazio!")
    private String telefone;

    @NotBlank(message = "O email não pode ser vazio!")
    @Email(message = "O email é inválido!")
    private String email;

    @NotBlank(message = "A senha não pode ser vazia!")
    @ValidPassword(message = "A senha não atende os critérios de validação!\nDeve ter ao menos uma letra maiúscula, minúscula, número e caracter especial!")
    private String senha;

    @NotBlank(message = "A senha não pode ser vazia!")
    @ValidPassword(message = "A senha não atende os critérios de validação!\nDeve ter ao menos uma letra maiúscula, minúscula, número e caracter especial!")
    private String coonfirmSenha;

    @NotBlank(message = "A razão social não pode ser vazia!")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 255 letras")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ\\sçÇ]+$", message = "A razão social deve conter apenas letras, espaços e \"ç\"")
    private String razaoSocial;

    @NotBlank(message = "O endereço não pode ser vazio!")
    @ValidAdress(message = "O endereço é inválido!")
    private String endereco;

    @NotBlank(message = "O CNPJ não pode ser vazio!")
    @CNPJ(message = "O número do cadastro nacional de pessoa jurídica(CPF) é inválido!")
    private String cnpj;

    public SignUpOngForm(@NotBlank @Phone String telefone, @NotBlank @Email String email, @NotBlank @ValidPassword String senha,
            @NotBlank @ValidPassword String coonfirmSenha,
            @NotBlank @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 255 letras!") @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ\\sçÇ]+$", message = "A razão social deve conter apenas letras, espaços e \"ç\"") String razaoSocial,
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
