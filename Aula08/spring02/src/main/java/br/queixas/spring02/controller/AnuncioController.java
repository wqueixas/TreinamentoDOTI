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

import br.queixas.spring02.dao.AnuncioDAO;
import br.queixas.spring02.model.Anuncio;

@RestController
@CrossOrigin("*")
@RequestMapping("/anuncio")
public class AnuncioController {

    @Autowired //injecao de dependencia
    private AnuncioDAO dao;

    @GetMapping("/all")
    public List<Anuncio> listarTodos() {
        List<Anuncio> listaAnuncios= (List<Anuncio>) dao.findAll();
        return listaAnuncios;
    }
    
    @PostMapping("/like")
    public ResponseEntity<List<Anuncio>> buscaLike(@RequestBody Anuncio anuncio) {
        List<Anuncio> procuraDescricao=dao.findByDescricaoLike(anuncio.getDescricao());

        
        if (procuraDescricao != null) {
            return ResponseEntity.ok(procuraDescricao);
        } 
        return ResponseEntity.notFound().build(); // http response 404
    }






}
