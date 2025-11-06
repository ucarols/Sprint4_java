package com.example.motoapi.dto;

import com.example.motoapi.model.Categoria;
import com.example.motoapi.model.Modelo;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MotoUpdateDTO {
    @Pattern(regexp = "^[A-Z0-9-]{3,10}$", message = "Placa inválida (apenas letras, números e hífen)")
    private String placa;

    private Modelo modelo;

    private Categoria categoria;

    private String observacao;
}
