package com.example.motoapi.service;

import com.example.motoapi.dto.MotoDTO;
import com.example.motoapi.model.Categoria;
import com.example.motoapi.model.Moto;
import com.example.motoapi.repository.MotoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MotoService {
    private final MotoRepository repository;

    public List<MotoDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public MotoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Moto não encontrada com ID: " + id));
    }
    
    public List<MotoDTO> buscarPorCategoria(Categoria categoria) {
        return repository.findAll().stream()
                .filter(m -> m.getCategoria() == categoria)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
    public MotoDTO buscarPorPlaca(String placa) {
        return repository.findAll().stream()
                .filter(m -> m.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .map(this::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Moto não encontrada com placa: " + placa));
    }

    public MotoDTO salvar(MotoDTO dto) {
        Moto moto = Moto.builder()
                .placa(dto.getPlaca())
                .modelo(dto.getModelo())
                .categoria(dto.getCategoria())
                .observacao(dto.getObservacao())
                .dataHoraEntrada(LocalDateTime.now())
                .imagemUrl(dto.getImagemUrl())
                .build();
        return toDTO(repository.save(moto));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public MotoDTO atualizar(Long id, MotoDTO dto) {
        Moto moto = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Moto não encontrada com ID: " + id));
        moto.setPlaca(dto.getPlaca());
        moto.setModelo(dto.getModelo());
        moto.setCategoria(dto.getCategoria());
        moto.setObservacao(dto.getObservacao());
        moto.setImagemUrl(dto.getImagemUrl());
        return toDTO(repository.save(moto));
    }

    private MotoDTO toDTO(Moto moto) {
        return MotoDTO.builder()
                .id(moto.getId())
                .placa(moto.getPlaca())
                .modelo(moto.getModelo())
                .categoria(moto.getCategoria())
                .observacao(moto.getObservacao())
                .dataHoraEntrada(moto.getDataHoraEntrada())
                .imagemUrl(moto.getImagemUrl())
                .build();
    }
}
