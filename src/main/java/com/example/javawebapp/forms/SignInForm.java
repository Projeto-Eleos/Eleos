package com.example.javawebapp.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import com.example.javawebapp.forms.ownsvalidations.ValidPassword;

public class SignInForm {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @ValidPassword
    private String password;

    public SignInForm(@NotBlank @Email String email, @NotBlank @ValidPassword String password) {
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
