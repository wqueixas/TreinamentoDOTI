package br.queixas.spring02.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //será armazenado em banco de dados
@Table(name="tbanuncio")
public class Anuncio {
    @Id //chave primaria no BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento
    @Column(name="id")
    private int id;

    @Column(name="descricao", length = 200, nullable = false, unique = true) //detalhes de criação da coluna
    private String descricao;

    @Column(name="valor", nullable = false) //detalhes de criação da coluna
    private double valor;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }



    
}
