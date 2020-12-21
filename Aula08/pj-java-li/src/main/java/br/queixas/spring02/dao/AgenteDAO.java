package br.queixas.spring02.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.queixas.spring02.model.Agente;

//CRUD - Creat Read Update Delete
public interface AgenteDAO extends CrudRepository<Agente, Integer> {

    @Query(value="select a.id_agente, a.nome_agente, a.volume_transacional from mtb310_ag_financeiro a order by a.volume_transacional desc", 
    nativeQuery = true)
    public List<Agente> listaPorVol();

    public List<Agente> findTop10ByOrderByVolumeTransacionalDesc();
    public List<Agente> findAllByOrderByIdAgente();

    public List<Agente> findByOrderByVolumeTransacionalDesc();


    
}
