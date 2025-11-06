package com.example.motoapi.dto;

import com.example.motoapi.model.Categoria;
import com.example.motoapi.model.Modelo;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MotoDTO {
    private Long id;
    
    @NotBlank(message = "Placa é obrigatória")
    @Pattern(regexp = "^[A-Z]{3}[0-9]{4}$", message = "Placa deve estar no formato ABC1234")
    private String placa;
    
    @NotNull(message = "Modelo é obrigatório")
    private Modelo modelo;
    
    @NotNull(message = "Categoria é obrigatória")
    private Categoria categoria;
    
    @Size(max = 500, message = "Observação deve ter no máximo 500 caracteres")
    private String observacao;
    
    private LocalDateTime dataHoraEntrada;
    
    @Pattern(regexp = "^(https?://.*|)$", message = "URL da imagem inválida")
    private String imagemUrl;
}
