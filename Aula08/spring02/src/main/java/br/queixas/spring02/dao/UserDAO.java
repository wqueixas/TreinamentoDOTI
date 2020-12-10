package br.queixas.spring02.dao;

import org.springframework.data.repository.CrudRepository;
import br.queixas.spring02.model.User;

//CRUD - Creat Read Update Delete
public interface UserDAO extends CrudRepository<User, Integer> {
    
    public User findByEmail(String email);

    public User findByEmailAndPassword(String email, String password);
    public User findByEmailOrCpf(String email, String cpf);
}
