package br.queixas.spring02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

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




}
