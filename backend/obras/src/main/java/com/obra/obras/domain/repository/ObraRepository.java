package com.obra.obras.domain.repository;

import com.obra.obras.domain.entity.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ObraRepository extends JpaRepository<Obra, Integer> {

    Optional<Obra> findById (Integer id);

    List<Obra> findByNomeLike(String nome);

    List<Obra> findByNomeOrIdOrderById(String nome, Integer id);

    Obra findOneByNome(String nome);

    void deleteByNome(String nome);

    boolean existsByNome(String nome);



}

