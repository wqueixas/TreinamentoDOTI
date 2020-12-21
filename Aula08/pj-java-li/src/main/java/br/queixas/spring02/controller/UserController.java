package br.queixas.spring02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.queixas.spring02.dao.UserDAO;
import br.queixas.spring02.dto.UserDTO;
import br.queixas.spring02.model.User;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired //injecao de dependencia
    private UserDAO dao;

    @GetMapping("/all")
    public List<User> listarTodos() {
        List<User> listaUsers= (List<User>) dao.findAll();
        return listaUsers;
    }

    /*
        @PostMapping("/new")
    public ResponseEntity<User> newUser(@RequestBody User newuser) {
        User novousuario = dao.save(newuser);
        return ResponseEntity.ok(novousuario);
    }  */

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody User user) {
        //System.out.println(user.getNome());
        User userFinded = dao.findByEmailOrRacf(user.getEmail(), user.getRacf());
        if(userFinded != null) {
            if(user.getPassword().equals(userFinded.getPassword())) {
                UserDTO userdto = new UserDTO(userFinded);
                return ResponseEntity.ok(userdto);
            }
            //return ResponseEntity.status(401).build(); -- mensagens de erro customizadas, podem dar margem a re engenharia
        }
        return ResponseEntity.notFound().build();
    }
}
