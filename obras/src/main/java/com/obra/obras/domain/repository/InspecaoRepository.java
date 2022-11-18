package com.obra.obras.domain.repository;

//import com.obra.obras.domain.entity.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import com.obra.obras.domain.entity.Inspecao;

import java.util.Optional;

public interface InspecaoRepository extends JpaRepository<Inspecao, Integer> {

    Optional<Inspecao> findById(Integer id);

}
