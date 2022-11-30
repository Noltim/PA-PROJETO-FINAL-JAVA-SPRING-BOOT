package com.obra.obras.domain.repository;

import com.obra.obras.domain.entity.ObraLocalizacao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraLocalizacaoRepository extends JpaRepository<ObraLocalizacao, Integer> {

    Optional<ObraLocalizacao> findById(Integer id);

}
