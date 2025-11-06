package com.example.motoapi.dto;

import com.example.motoapi.model.Categoria;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MotoAlertaDTO {
    private Long id;
    private String placa;
    private Categoria categoria;
    private LocalDateTime dataHoraEntrada;
    private Long minutosNoPateo;
    private Long minutosAcimaDolimite;
    private String nivelAlerta;
    private String mensagem;
}
