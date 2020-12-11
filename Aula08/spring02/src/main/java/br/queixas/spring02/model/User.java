package br.queixas.spring02.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //será armazenado em banco de dados
@Table(name="tbuser")
@Getter @Setter @NoArgsConstructor
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
    @JsonIgnoreProperties("user")
    private List<Anuncio> anuncios;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    

 



    
}
