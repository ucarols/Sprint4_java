package com.example.motoapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tab_motos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moto_seq")
    @SequenceGenerator(name = "moto_seq", sequenceName = "MOTO_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Modelo modelo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private String observacao;

    private LocalDateTime dataHoraEntrada;

    private String imagemUrl;
}
