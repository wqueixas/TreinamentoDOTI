package br.queixas.spring02.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //será armazenado em banco de dados
@Table(name="mtb310_usuario")
@Getter @Setter @NoArgsConstructor
public class User {
    @Id //chave primaria no BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento
    @Column(name="id")
    private int id;

    @Column(name="racf", length = 8, nullable = false) //detalhes de criação da coluna
    private String racf;

    @Column(name="nome", length = 50, nullable = false) //detalhes de criação da coluna
    private String nome;

    @Column(name="email", length = 100, nullable = false, unique = true) //detalhes de criação da coluna
    private String email;

    @Column(name="foto", length = 20, nullable = false, unique = true) //detalhes de criação da coluna
    private String foto;

    @Column(name="password", length = 20, nullable = false) //detalhes de criação da coluna
    private String password;

    public User(String name, String email) {
        this.nome = name;
        this.email = email;
    }

    

 



    
}
