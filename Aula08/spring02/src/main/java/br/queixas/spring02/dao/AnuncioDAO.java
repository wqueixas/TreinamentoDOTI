package br.queixas.spring02.dao;

import org.springframework.data.repository.CrudRepository;

import br.queixas.spring02.model.Anuncio;

//CRUD - Creat Read Update Delete
public interface AnuncioDAO extends CrudRepository<Anuncio, Integer> {
    
    public Anuncio findByDescricao(String descricao);
    public Anuncio findByDescricaoLike(String descricao);

    public Anuncio findByDescricaoAndValor(String descricao, double valor);
    public Anuncio findByDescricaoOrValor(String descricao, double valor);
    public Anuncio findByValor(double valor);
}
