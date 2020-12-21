package br.queixas.spring02.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.queixas.spring02.dto.ContagemStatusDto;
import br.queixas.spring02.model.Transacoes;


public interface TransacoesDAO extends CrudRepository<Transacoes, Integer>{
    
    //@Query(value="SELECT new  br.queixas.spring02.dto.ContagemStatusDto ('abc', status, COUNT(t.status)) FROM Transacoes AS t WHERE t.idTransacao = ?1 GROUP BY  t.status ORDER By status")
    @Query(value="SELECT new br.queixas.spring02.dto.ContagemStatusDto (t.agente.nomeAgente, status, COUNT(t.status)) FROM Transacoes AS t WHERE t.agente.idAgente = ?1 GROUP BY t.agente.nomeAgente, t.status ORDER By status")
    public List<ContagemStatusDto> countStatusByAgent(int idAgente); 

  


}
