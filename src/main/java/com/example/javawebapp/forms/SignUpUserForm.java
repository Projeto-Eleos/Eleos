package com.example.javawebapp.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.example.javawebapp.forms.ownsvalidations.DateBetween;
import com.example.javawebapp.forms.ownsvalidations.Phone;
import com.example.javawebapp.forms.ownsvalidations.ValidPassword;

import java.util.Date;

public class SignUpUserForm {
    @Phone(message = "O telefone é inválido!")
    @NotBlank(message = "O telefone não pode ser vazio!")
    private String telefone;

    @NotBlank(message = "O email não pode ser vazio!")
    @Email(message = "O email é inválido!")
    private String email;

    @NotBlank(message = "O senha não pode ser vazio!")
    @ValidPassword(message = "A senha não atende os critérios de validação!\nDeve ter ao menos uma letra maiúscula, minúscula, número e caracter especial!")
    private String senha;

    @NotBlank(message = "O senha não pode ser vazio!")
    private String confirmSenha;

    @NotBlank(message = "O nome não pode ser vazio!")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 255 letras!")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ\\sçÇ]+$", message = "O nome deve conter apenas letras, espaços e \"ç\"")
    private String name;

    @NotBlank(message = "O sobrenome não pode ser vazio!")
    @Size(min = 2, max = 50, message = "O sobrenome deve ter entre 2 e 255 letras!")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ\\sçÇ]+$", message = "O sobrenome deve conter apenas letras, espaços e \"ç\"")
    private String sobrenome;

    @NotBlank(message = "O CPF não pode ser vazio!")
    @CPF(message = "O número do cadastro de pessoa física brasileira(CPF) é inválido!")
    private String cpf;

    @DateBetween(message = "Você deve ter entre 18 e 124 anos para se cadastrar no site!")
    private Date dataNascimento;

    public SignUpUserForm(@Phone String telefone, @Email String email, @ValidPassword String senha, @ValidPassword String confirmSenha,
            @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 255 letras") @Pattern(regexp = "^[A-Za-z]+$", message = "O nome deve conter apenas letras") String name,
            @Size(min = 2, max = 50, message = "O sobrenome deve ter entre 2 e 255 letras") @Pattern(regexp = "^[A-Za-z]+$", message = "O sobrenome deve conter apenas letras") String sobrenome,
            @CPF String cpf, @DateBetween Date dataNascimento) {
        this.telefone = telefone;
        this.email = email;
        this.confirmSenha = confirmSenha;
        this.senha = senha;
        this.name = name;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
}
