package com.engdb.automatizador.controller;

import com.engdb.automatizador.entity.Ambiente;
import com.engdb.automatizador.repository.AmbienteRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/ambiente")
public class AmbienteController {


    @GetMapping("/hello")
    public String hello() {
        return "Eu estou vivo agora " + new Date();
    }

    @Autowired
    AmbienteRepository repository;

    @GetMapping("/all")
    public ResponseEntity getAll() {

        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Validated @RequestBody Ambiente ambiente) {

        Optional<Ambiente> ambienteProcurado = repository.findByNome(ambiente.getNome());

        if (ambienteProcurado.isPresent()) {
            return ResponseEntity.badRequest().body("Esse ambiente ja existe");
        }

        return ResponseEntity.ok(repository.save(ambiente));
    }

    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable Long id) {

        return ResponseEntity.ok(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        if (!(repository.existsById(id))) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok().body("Ambiente deletado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable Long id, @Validated @RequestBody Ambiente ambienteAtributos) {
        return repository.findById(id).map(ambienteEncontrado -> {
            Ambiente ambienteAtualizado = ambienteEncontrado;
            ambienteAtualizado.setNome(ambienteAtributos.getNome());
            ambienteAtualizado.setHost(ambienteAtributos.getHost());
            ambienteAtualizado.setIp(ambienteAtributos.getIp());
            ambienteAtualizado.setDescricao(ambienteAtributos.getDescricao());
            ambienteAtualizado.setPorta(ambienteAtributos.getPorta());
            return ResponseEntity.ok().body(repository.save(ambienteAtualizado));
        }).orElse(ResponseEntity.notFound().build());
    }
}


