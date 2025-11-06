package com.example.motoapi.dto;

import com.example.motoapi.model.Categoria;
import com.example.motoapi.model.Modelo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MotoCreateDTO {
    @NotBlank(message = "Placa é obrigatória")
    @Pattern(regexp = "^[A-Z0-9-]{3,10}$", message = "Placa inválida (apenas letras, números e hífen)")
    private String placa;

    @NotNull(message = "Modelo é obrigatório")
    private Modelo modelo;

    @NotNull(message = "Categoria é obrigatória")
    private Categoria categoria;

    private String observacao;
}
