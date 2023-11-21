package com.example.javawebapp.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class SignInForm {
    @NotBlank(message = "O email não pode ser vazio!")
    @Email(message = "O email é inválido!")
    private String email;

    @NotBlank@NotBlank(message = "O email não pode ser vazio!")
    private String password;

    public SignInForm(@NotBlank @Email String email, @NotBlank String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
