package com.engdb.automatizador.repository;

import com.engdb.automatizador.entity.Ambiente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AmbienteRepository extends JpaRepository<Ambiente, Long> {

    Optional<Ambiente> findByNome(String nome);



}