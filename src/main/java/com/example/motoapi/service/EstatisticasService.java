package com.example.motoapi.service;

import com.example.motoapi.dto.EstatisticasDTO;
import com.example.motoapi.model.Categoria;
import com.example.motoapi.model.Moto;
import com.example.motoapi.model.Modelo;
import com.example.motoapi.repository.MotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EstatisticasService {
    private final MotoRepository repository;
    private final AlertaService alertaService;
    
    /**
     * Retorna estatísticas completas do pátio
     */
    public EstatisticasDTO obterEstatisticas() {
        List<Moto> todasMotos = repository.findAll();
        
        long totalMotos = todasMotos.size();
        long motosVerdes = contarPorCategoria(todasMotos, Categoria.VERDE);
        long motosAmarelas = contarPorCategoria(todasMotos, Categoria.AMARELA);
        long motosVermelhas = contarPorCategoria(todasMotos, Categoria.VERMELHA);
        long motosRoxas = contarPorCategoria(todasMotos, Categoria.ROXA);
        
        long motosComAlerta = alertaService.listarMotosComAlerta().size();
        long motosForaDoPrazo = alertaService.listarMotosForaDoPrazo().size();
        
        Map<String, Long> motosPorModelo = new HashMap<>();
        motosPorModelo.put("SPORT", contarPorModelo(todasMotos, Modelo.SPORT));
        motosPorModelo.put("MOTTU_E", contarPorModelo(todasMotos, Modelo.MOTTU_E));
        motosPorModelo.put("MOTTU_POP", contarPorModelo(todasMotos, Modelo.MOTTU_POP));
        
        double tempoMedio = calcularTempoMedio(todasMotos);
        String statusGeral = calcularStatusGeral(motosComAlerta, motosForaDoPrazo, totalMotos);
        
        return EstatisticasDTO.builder()
                .totalMotos(totalMotos)
                .motosVerdes(motosVerdes)
                .motosAmarelas(motosAmarelas)
                .motosVermelhas(motosVermelhas)
                .motosRoxas(motosRoxas)
                .motosComAlerta(motosComAlerta)
                .motosForaDoPrazo(motosForaDoPrazo)
                .motosPorModelo(motosPorModelo)
                .tempoMedioNoPateo(tempoMedio)
                .statusGeral(statusGeral)
                .build();
    }
    
    private long contarPorCategoria(List<Moto> motos, Categoria categoria) {
        return motos.stream()
                .filter(m -> m.getCategoria() == categoria)
                .count();
    }
    
    private long contarPorModelo(List<Moto> motos, Modelo modelo) {
        return motos.stream()
                .filter(m -> m.getModelo() == modelo)
                .count();
    }
    
    private double calcularTempoMedio(List<Moto> motos) {
        if (motos.isEmpty()) return 0.0;
        
        LocalDateTime agora = LocalDateTime.now();
        double somaMinutos = motos.stream()
                .mapToLong(moto -> {
                    LocalDateTime entrada = moto.getDataHoraEntrada() != null ? 
                            moto.getDataHoraEntrada() : agora;
                    return Duration.between(entrada, agora).toMinutes();
                })
                .sum();
        
        return somaMinutos / motos.size();
    }
    
    private String calcularStatusGeral(long comAlerta, long foraDoPrazo, long total) {
        if (total == 0) return "OTIMO";
        
        double percentualAlerta = (double) comAlerta / total * 100;
        double percentualForaDoPrazo = (double) foraDoPrazo / total * 100;
        
        if (percentualForaDoPrazo > 30 || percentualAlerta > 50) {
            return "CRITICO";
        } else if (percentualForaDoPrazo > 15 || percentualAlerta > 30) {
            return "ATENCAO";
        } else if (percentualAlerta > 10) {
            return "BOM";
        } else {
            return "OTIMO";
        }
    }
}
