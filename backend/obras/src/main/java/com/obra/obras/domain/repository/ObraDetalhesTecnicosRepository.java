package com.obra.obras.domain.repository;

import com.obra.obras.domain.entity.ObraDetalhesTecnicos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraDetalhesTecnicosRepository extends JpaRepository<ObraDetalhesTecnicos, Integer> {

    Optional<ObraDetalhesTecnicos> findById(Integer id);
}
