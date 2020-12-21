package br.queixas.spring02.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //será armazenado em banco de dados
@Table(name="mtb310_transaction")
@Getter @Setter @NoArgsConstructor
public class Transacoes {
    @Id //chave primaria no BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento
    @Column(name="id_transacao")
    private int idTransacao;

    @Column(name="dispositivo") //detalhes de criação da coluna
    private int dispositivo;

    @Column(name = "data_hora", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    @Column(name="valor_solic") //detalhes de criação da coluna
    private float valorSolic;

    @Column(name="valor_aut") //detalhes de criação da coluna
    private float valorAut;

    @Column(name="status") //detalhes de criação da coluna
    private int status;

    @ManyToOne
    @JoinColumn(name="ag_financeiro")
    @JsonIgnoreProperties("transacoes")
    private Agente agente;


    

 



    
}
