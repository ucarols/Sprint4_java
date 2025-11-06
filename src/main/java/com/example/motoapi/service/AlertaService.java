package com.example.motoapi.service;

import com.example.motoapi.dto.MotoAlertaDTO;
import com.example.motoapi.model.Categoria;
import com.example.motoapi.model.Moto;
import com.example.motoapi.repository.MotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlertaService {
    private final MotoRepository repository;
    
    private static final long LIMITE_AMARELA = 15;
    private static final long LIMITE_VERMELHA = 0;
    private static final long LIMITE_ROXA = 0;
    public List<MotoAlertaDTO> listarMotosComAlerta() {
        return repository.findAll().stream()
                .map(this::calcularAlerta)
                .filter(alerta -> !alerta.getNivelAlerta().equals("NORMAL"))
                .collect(Collectors.toList());
    }
    
    public List<MotoAlertaDTO> listarMotosForaDoPrazo() {
        return repository.findAll().stream()
                .map(this::calcularAlerta)
                .filter(alerta -> alerta.getMinutosAcimaDolimite() != null && alerta.getMinutosAcimaDolimite() > 0)
                .collect(Collectors.toList());
    }
    
    public List<MotoAlertaDTO> listarPorPrioridade() {
        return repository.findAll().stream()
                .map(this::calcularAlerta)
                .sorted((a, b) -> {
                    int nivelCompare = getNivelPrioridade(b.getNivelAlerta()) - getNivelPrioridade(a.getNivelAlerta());
                    if (nivelCompare != 0) return nivelCompare;
                    return b.getMinutosNoPateo().compareTo(a.getMinutosNoPateo());
                })
                .collect(Collectors.toList());
    }
    
    private MotoAlertaDTO calcularAlerta(Moto moto) {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime entrada = moto.getDataHoraEntrada() != null ? moto.getDataHoraEntrada() : agora;
        long minutosNoPateo = Duration.between(entrada, agora).toMinutes();
        
        String nivelAlerta = "NORMAL";
        String mensagem = "Moto dentro do prazo esperado";
        Long minutosAcima = null;
        
        switch (moto.getCategoria()) {
            case AMARELA:
                if (minutosNoPateo > LIMITE_AMARELA * 2) {
                    nivelAlerta = "CRITICO";
                    minutosAcima = minutosNoPateo - LIMITE_AMARELA;
                    mensagem = String.format("URGENTE! Moto ultrapassou em %d minutos o limite de %d minutos para reparos rápidos", 
                            minutosAcima, LIMITE_AMARELA);
                } else if (minutosNoPateo > LIMITE_AMARELA) {
                    nivelAlerta = "ATENCAO";
                    minutosAcima = minutosNoPateo - LIMITE_AMARELA;
                    mensagem = String.format("Atenção! Moto ultrapassou em %d minutos o limite de %d minutos", 
                            minutosAcima, LIMITE_AMARELA);
                } else if (minutosNoPateo > LIMITE_AMARELA * 0.8) {
                    nivelAlerta = "ATENCAO";
                    mensagem = String.format("Atenção! Moto próxima do limite de %d minutos (faltam %d minutos)", 
                            LIMITE_AMARELA, LIMITE_AMARELA - minutosNoPateo);
                }
                break;
                
            case VERMELHA:
                if (minutosNoPateo > 60) {
                    nivelAlerta = "CRITICO";
                    mensagem = String.format("CRÍTICO! Moto com problema grave há %d minutos. Prioridade máxima!", minutosNoPateo);
                } else if (minutosNoPateo > 30) {
                    nivelAlerta = "ATENCAO";
                    mensagem = String.format("Moto com problema grave há %d minutos. Requer atenção urgente!", minutosNoPateo);
                } else {
                    nivelAlerta = "ATENCAO";
                    mensagem = "Moto com problema grave. Prioridade alta!";
                }
                break;
                
            case ROXA:
                if (minutosNoPateo > 1440) {
                    nivelAlerta = "CRITICO";
                    long dias = minutosNoPateo / 1440;
                    mensagem = String.format("CRÍTICO! Problema administrativo pendente há %d dia(s)", dias);
                } else if (minutosNoPateo > 480) {
                    nivelAlerta = "ATENCAO";
                    long horas = minutosNoPateo / 60;
                    mensagem = String.format("Problema administrativo pendente há %d hora(s)", horas);
                } else {
                    mensagem = "Aguardando resolução de problema administrativo";
                }
                break;
                
            case VERDE:
                if (minutosNoPateo > 120) {
                    nivelAlerta = "ATENCAO";
                    mensagem = String.format("Moto pronta há %d minutos. Pode ser liberada para uso", minutosNoPateo);
                } else {
                    mensagem = "Moto pronta para uso";
                }
                break;
        }
        
        return MotoAlertaDTO.builder()
                .id(moto.getId())
                .placa(moto.getPlaca())
                .categoria(moto.getCategoria())
                .dataHoraEntrada(entrada)
                .minutosNoPateo(minutosNoPateo)
                .minutosAcimaDolimite(minutosAcima)
                .nivelAlerta(nivelAlerta)
                .mensagem(mensagem)
                .build();
    }
    
    private int getNivelPrioridade(String nivel) {
        return switch (nivel) {
            case "CRITICO" -> 3;
            case "ATENCAO" -> 2;
            case "NORMAL" -> 1;
            default -> 0;
        };
    }
}
