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
    @Phone
    @NotBlank
    private String telefone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @ValidPassword
    private String senha;

    @NotBlank
    @ValidPassword
    private String confirmSenha;

    @NotBlank
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 255 letras")
    @Pattern(regexp = "^[A-Za-z]+$", message = "O nome deve conter apenas letras")
    private String name;

    @NotBlank
    @Size(min = 2, max = 50, message = "O sobrenome deve ter entre 2 e 255 letras")
    @Pattern(regexp = "^[A-Za-z]+$", message = "O sobrenome deve conter apenas letras")
    private String sobrenome;

    @NotBlank
    @CPF
    private String cpf;

    @Past(message = "A data de nascimento deve estar no passado")
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

    // Getters e setters
}
