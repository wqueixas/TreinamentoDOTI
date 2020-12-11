package br.queixas.spring02.dto;

import br.queixas.spring02.model.User;

//Data Transfer Object
public class UserDTO {
    private String name;
    private String email;
    private String cpf;

    public UserDTO(User usuario) {
        this.name = usuario.getName();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
