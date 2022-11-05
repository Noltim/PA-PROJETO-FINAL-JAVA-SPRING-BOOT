package com.obra.obras.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.obra.obras.domain.entity.Inspecao;

public interface Inspecoes extends JpaRepository<Inspecao, Integer> {
}
