package com.example.motoapi.dto;

import lombok.*;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstatisticasDTO {
    private Long totalMotos;
    private Long motosVerdes;
    private Long motosAmarelas;
    private Long motosVermelhas;
    private Long motosRoxas;
    private Long motosComAlerta;
    private Long motosForaDoPrazo;
    private Map<String, Long> motosPorModelo;
    private Double tempoMedioNoPateo;
    private String statusGeral;
}
