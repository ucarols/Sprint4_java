package com.example.motoapi.dto;

import com.example.motoapi.model.Categoria;
import com.example.motoapi.model.Modelo;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MotoResponseDTO {
    private Long id;
    private String placa;
    private Modelo modelo;
    private Categoria categoria;
    private String observacao;
    private LocalDateTime dataHoraEntrada;
}
