package com.example.motoapi.controller;

import com.example.motoapi.dto.MotoDTO;
import com.example.motoapi.model.Categoria;
import com.example.motoapi.service.MotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motos")
@RequiredArgsConstructor
@Tag(name = "Motos", description = "CRUD de motocicletas")
public class MotoController {
    private final MotoService service;

    @GetMapping
    @Operation(summary = "Listar todas as motos", description = "Retorna lista completa de motocicletas cadastradas")
    public List<MotoDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar moto por ID", description = "Retorna uma motocicleta específica pelo ID")
    public MotoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
    
    @GetMapping("/categoria/{categoria}")
    @Operation(summary = "Buscar motos por categoria", description = "Retorna todas as motos de uma categoria específica")
    public List<MotoDTO> buscarPorCategoria(@PathVariable Categoria categoria) {
        return service.buscarPorCategoria(categoria);
    }
    
    @GetMapping("/placa/{placa}")
    @Operation(summary = "Buscar moto por placa", description = "Retorna uma motocicleta pela placa")
    public MotoDTO buscarPorPlaca(@PathVariable String placa) {
        return service.buscarPorPlaca(placa);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar nova moto", description = "Cria um novo registro de motocicleta")
    public MotoDTO criar(@Valid @RequestBody MotoDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar moto", description = "Atualiza os dados de uma motocicleta existente")
    public MotoDTO atualizar(@PathVariable Long id, @Valid @RequestBody MotoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar moto", description = "Remove uma motocicleta do sistema")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
