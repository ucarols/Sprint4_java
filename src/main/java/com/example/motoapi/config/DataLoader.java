package com.example.motoapi.config;

import com.example.motoapi.model.Categoria;
import com.example.motoapi.model.Modelo;
import com.example.motoapi.model.Moto;
import com.example.motoapi.repository.MotoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(MotoRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(Moto.builder()
                        .placa("ABC1234")
                        .modelo(Modelo.MOTTU_POP)
                        .categoria(Categoria.AMARELA)
                        .observacao("Moto de teste 1")
                        .dataHoraEntrada(LocalDateTime.now().minusHours(2))
                        .build());

                repo.save(Moto.builder()
                        .placa("XYZ9999")
                        .modelo(Modelo.SPORT)
                        .categoria(Categoria.VERMELHA)
                        .observacao("Moto de teste 2")
                        .dataHoraEntrada(LocalDateTime.now().minusMinutes(30))
                        .build());
            }
        };
    }
}
