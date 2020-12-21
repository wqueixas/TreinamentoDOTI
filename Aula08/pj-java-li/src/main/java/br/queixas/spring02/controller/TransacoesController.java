package br.queixas.spring02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.queixas.spring02.dao.TransacoesDAO;
import br.queixas.spring02.dto.ContagemStatusDto;
import br.queixas.spring02.model.Transacoes;

@RestController
@CrossOrigin("*")
@RequestMapping("/transacoes")
public class TransacoesController {
             
    // anotação
    @Autowired
    // JPA cria classe a partir do UserDAO com todos os métodos, gerando objeto
    // "dao"
    // injeção de dependência
    private TransacoesDAO dao;


    // métodos - pedidos usuários e devolver
    @PostMapping("/all")
    public List<Transacoes> listarTodos() {
        List<Transacoes> lista = (List<Transacoes>) dao.findAll();
        return lista;
     }
  

    @PostMapping("/id/{id}") // nome da variável = {id}
    public ResponseEntity<List<ContagemStatusDto>> contagemStatus(@PathVariable int id) { // igual ao nome acima - fazer correspondência
        // findbyid - retornar objeto
        // criar objeto "user" para receber
        // se não achou, move nullo
        List<ContagemStatusDto>  contagem = dao.countStatusByAgent(id); //??? .orElse(null);

        if (contagem != null) {
            return ResponseEntity.ok(contagem); // 200 - achou e volta objeto
        } else {
            return ResponseEntity.notFound().build(); // 404 - not found e montar estrutura vazio
        }
    } 

}
