package com.obra.obras.domain.repository;

//import com.obra.obras.domain.entity.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import com.obra.obras.domain.entity.Inspecao;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InspecaoRepository extends JpaRepository<Inspecao, Integer> {

    Optional<Inspecao> findById(Integer id);

}
