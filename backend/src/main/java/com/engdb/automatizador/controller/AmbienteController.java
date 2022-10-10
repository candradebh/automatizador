package com.engdb.automatizador.controller;

import com.engdb.automatizador.entity.Ambiente;
import com.engdb.automatizador.repository.AmbienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ambiente")
public class AmbienteController {

    @Autowired
    AmbienteRepository repository;

    @GetMapping("/all")
    public ResponseEntity getAll (){

        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity create (@Validated @RequestBody Ambiente ambiente){

        Optional<Ambiente> ambienteProcurado = repository.findByNome(ambiente.getNome());

        if(ambienteProcurado.isPresent()){
            return  ResponseEntity.badRequest().body("Esse ambiente ja existe");
        }

        return ResponseEntity.ok(repository.save(ambiente));
    }

    @GetMapping("/{id}")
    public ResponseEntity read (@PathVariable Long id){

        return ResponseEntity.ok(repository.findById(id));
    }


    // PUT

    //DELETE




}
