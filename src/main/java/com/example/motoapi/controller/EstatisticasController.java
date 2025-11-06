package com.example.motoapi.controller;

import com.example.motoapi.dto.EstatisticasDTO;
import com.example.motoapi.service.EstatisticasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estatisticas")
@RequiredArgsConstructor
@Tag(name = "Estatísticas", description = "Dashboard e relatórios do pátio")
public class EstatisticasController {
    private final EstatisticasService estatisticasService;
    
    @GetMapping
    @Operation(summary = "Obter estatísticas do pátio", 
               description = "Retorna dashboard completo com métricas e indicadores do pátio")
    public EstatisticasDTO obterEstatisticas() {
        return estatisticasService.obterEstatisticas();
    }
}
