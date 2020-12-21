package br.queixas.spring02.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.queixas.spring02.model.User;

//CRUD - Creat Read Update Delete
public interface UserDAO extends CrudRepository<User, Integer> {
    
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);
    public User findByRacfAndPassword(String racf, String password);
    public User findByEmailOrRacf(String email, String racf);


    @Query(value="select new User(nome, email) from User where id = :cod")
    public User buscaPorId(@Param("cod") Integer codigo);
/* 
    @Query(value="select name, email from tbuser where id=:cod")
    public User buscaPorIdPersonalizado(@Param("cod") Integer codigo); */
}
