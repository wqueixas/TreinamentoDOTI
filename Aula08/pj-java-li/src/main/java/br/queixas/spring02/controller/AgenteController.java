package br.queixas.spring02.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.queixas.spring02.dao.AgenteDAO;
import br.queixas.spring02.dto.AgenteDTO;
import br.queixas.spring02.model.Agente;

@RestController
@CrossOrigin("*")
@RequestMapping("/agente")
public class AgenteController {

    @Autowired //injecao de dependencia
    private AgenteDAO dao;

/*     @PostMapping("/all")
    public List<Agente> listarTodos() {
        List<Agente> listaUsers= (List<Agente>) dao.findAll();
        return listaUsers;
    } */

    @PostMapping("/top10")
    public List<AgenteDTO> top10() {
        List<Agente> listaAgentes= (List<Agente>) dao.findTop10ByOrderByVolumeTransacionalDesc();
        List<AgenteDTO> listaAgenteDTOs = new ArrayList<AgenteDTO>();
        for (Agente agente : listaAgentes) {
            AgenteDTO agdto = new AgenteDTO(agente);
            listaAgenteDTOs.add(agdto);
        }
        return listaAgenteDTOs;
    }    

    @PostMapping("/lista")
    public List<AgenteDTO> lista() {
        List<Agente> listaAgentes= (List<Agente>) dao.findAllByOrderByIdAgente();
        List<AgenteDTO> listaAgenteDTOs = new ArrayList<AgenteDTO>();
        for (Agente agente : listaAgentes) {
            AgenteDTO agdto = new AgenteDTO(agente);
            listaAgenteDTOs.add(agdto);
        }
        return listaAgenteDTOs;
    }
/* 
    @GetMapping("/litaPorVolume")
    public List<Agente> AgPorVolume() {
        List<Agente> listaAgentes=(List<Agente>) dao.listaPorVol();
        return listaAgentes;
    } */

/*     @PostMapping("/new")
    public ResponseEntity<Agente> newUser(@RequestBody Agente newAgente) {
        Agente novousuario = dao.save(newAgente);
        return ResponseEntity.ok(novousuario);
    } */


    @GetMapping("/listaPorVol") // entre {} fica o nome da variavel
    public ResponseEntity<Object> AgPorVolume() { //metodo vai fazer uma query montada maualmente em UserDAO
        Object agentes=(Object)dao.listaPorVol();
        if (agentes != null) {
            return ResponseEntity.ok(agentes);
        } 
        return ResponseEntity.notFound().build(); // http response 404
    }

    @GetMapping("/listaAgentes") // entre {} fica o nome da variavel
    public ResponseEntity<List<Agente>> buscarPersonalizado() { // metodo vai fazer uma query
                                                                                    // montada maualmente em UserDAO
        List<Agente> agentes=dao.listaPorVol();
        if (agentes != null) {
            return ResponseEntity.ok(agentes);
        } 
        return ResponseEntity.notFound().build(); // http response 404
    }
}
