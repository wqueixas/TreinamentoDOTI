package br.queixas.spring02.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //será armazenado em banco de dados
@Table(name="tbuser")
public class User {
    @Id //chave primaria no BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento
    @Column(name="id")
    private int id;

    @Column(name="name", length = 150, nullable = false) //detalhes de criação da coluna
    private String name;

    @Column(name="email", length = 100, nullable = false, unique = true) //detalhes de criação da coluna
    private String email;

    @Column(name="cpf", length = 11, nullable = false, unique = true) //detalhes de criação da coluna
    private String cpf;

    @Column(name="pasword", length = 30, nullable = false) //detalhes de criação da coluna
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Anuncio> anuncios;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }



    
}
