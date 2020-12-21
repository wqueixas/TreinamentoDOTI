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
@Table(name="mtb310_ag_financeiro")
@Getter @Setter @NoArgsConstructor
public class Agente {
    @Id //chave primaria no BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento
    @Column(name="id_agente")
    private int idAgente;

    @Column(name="nome_agente", length = 100) //detalhes de criação da coluna
    private String nomeAgente;

    @Column(name="volume_transacional") //detalhes de criação da coluna
    private float volumeTransacional;

    @OneToMany(mappedBy = "agente")
    @JsonIgnoreProperties("agente")
    private List<Transacoes> transacoes;

    public Agente(String nome_agente) {
        this.nomeAgente = nome_agente;
    }

    

 



    
}
