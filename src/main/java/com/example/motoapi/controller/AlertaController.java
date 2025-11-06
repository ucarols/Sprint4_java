package com.example.motoapi.controller;

import com.example.motoapi.dto.MotoAlertaDTO;
import com.example.motoapi.service.AlertaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
@RequiredArgsConstructor
@Tag(name = "Alertas", description = "Sistema de alertas e notificações de motos")
public class AlertaController {
    private final AlertaService alertaService;
    
    @GetMapping
    @Operation(summary = "Listar todas as motos com alertas ativos", 
               description = "Retorna motos que requerem atenção (níveis ATENCAO ou CRITICO)")
    public List<MotoAlertaDTO> listarMotosComAlerta() {
        return alertaService.listarMotosComAlerta();
    }
    
    @GetMapping("/fora-prazo")
    @Operation(summary = "Listar motos fora do prazo", 
               description = "Retorna motos que ultrapassaram o tempo limite da sua categoria")
    public List<MotoAlertaDTO> listarMotosForaDoPrazo() {
        return alertaService.listarMotosForaDoPrazo();
    }
    
    @GetMapping("/prioridade")
    @Operation(summary = "Listar motos por prioridade", 
               description = "Retorna todas as motos ordenadas por prioridade (mais urgentes primeiro)")
    public List<MotoAlertaDTO> listarPorPrioridade() {
        return alertaService.listarPorPrioridade();
    }
}
