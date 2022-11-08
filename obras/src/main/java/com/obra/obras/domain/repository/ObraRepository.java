package com.obra.obras.domain.repository;

import com.obra.obras.domain.entity.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//vai fazer operações na DB

public interface ObraRepository extends JpaRepository<Obra, Integer> {

    List<Obra> findByNomeLike(String nome);

    List<Obra> findByNomeOrIdOrderById(String nome, Integer id);

    Obra findOneByNome(String nome);

    void deleteByNome(String nome);

    boolean existsByNome(String nome);


}

