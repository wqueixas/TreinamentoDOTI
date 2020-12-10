package br.queixas.spring02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/id/{userid}") // entre {} fica o nome da variavel
    public ResponseEntity<User> buscaID(@PathVariable int userid) {
        User usuario=dao.findById(userid).orElse(null);
        if (usuario != null) {
            usuario.setPassword("XXXXXXXX");
            return ResponseEntity.ok(usuario);
        } 
        return ResponseEntity.notFound().build(); // http response 404
    }

    @PostMapping("/new")
    public ResponseEntity<User> newUser(@RequestBody User newuser) {
        User novousuario = dao.save(newuser);
        return ResponseEntity.ok(novousuario);
    }

    @PostMapping("/email")
    public ResponseEntity<UserDTO> buscaPorEmail(@RequestBody User user) {
        User usuario=dao.findByEmail(user.getEmail());
        
        if (usuario != null) {
            UserDTO userdto = new UserDTO(usuario);
            return ResponseEntity.ok(userdto);
        } 
        return ResponseEntity.notFound().build(); // http response 404
    }    

    @PostMapping("/loginemail")
    public ResponseEntity<UserDTO> loginPorEmail(@RequestBody User user) {
        User usuario=dao.findByEmailAndPassword(user.getEmail(), user.getPassword());
        
        if (usuario != null) {
            UserDTO userdto = new UserDTO(usuario);
            return ResponseEntity.ok(userdto);
        } 
        return ResponseEntity.notFound().build(); // http response 404
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody User user) {
        User userFinded = dao.findByEmailOrCpf(user.getEmail(), user.getCpf());
        if(userFinded != null) {
            if(user.getPassword().equals(userFinded.getPassword())) {
                UserDTO userdto = new UserDTO(user);
                return ResponseEntity.ok(userdto);
            }
            //return ResponseEntity.status(401).build(); -- mensagens de erro customizadas, podem dar margem a re engenharia
        }
        return ResponseEntity.status(403).build();
    }
}
