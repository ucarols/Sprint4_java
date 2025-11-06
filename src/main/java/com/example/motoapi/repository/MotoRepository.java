package com.example.motoapi.repository;

import com.example.motoapi.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
    boolean existsByPlaca(String placa);
}
