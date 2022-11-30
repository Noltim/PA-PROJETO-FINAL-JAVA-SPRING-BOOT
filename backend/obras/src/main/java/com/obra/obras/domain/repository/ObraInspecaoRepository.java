package com.obra.obras.domain.repository;

import com.obra.obras.domain.entity.ObraInspecao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraInspecaoRepository extends JpaRepository<ObraInspecao, Integer> {

    @Query(" select c from ObraInspecao c left join fetch c.inspecoes where c.id = :id ")
    ObraInspecao findObraInspecaoFetchInspecoes(@Param("id") Integer id);

    Optional<ObraInspecao> findById(Integer id);

}
