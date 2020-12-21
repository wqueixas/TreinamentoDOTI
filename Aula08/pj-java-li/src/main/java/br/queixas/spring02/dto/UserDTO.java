package br.queixas.spring02.dto;

import br.queixas.spring02.model.User;

//Data Transfer Object
public class UserDTO {
    private String name;
    private String email;
    private String racf;
    private String foto;

    public UserDTO(User usuario) {
        this.name = usuario.getNome();
        this.email = usuario.getEmail();
        this.racf = usuario.getRacf();
        this.foto = usuario.getFoto();
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

    public String getRacf() {
        return racf;
    }

    public void setRacf(String racf) {
        this.racf = racf;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
}
