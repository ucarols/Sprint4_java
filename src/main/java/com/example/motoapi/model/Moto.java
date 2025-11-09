package com.example.motoapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_MOTOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moto_seq")
    @SequenceGenerator(name = "moto_seq", sequenceName = "MOTO_SEQ", allocationSize = 1)
    @Column(name = "id_moto")
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

    @Column(name = "data_entrada")
    private LocalDateTime dataHoraEntrada;

    private String imagemUrl;

    @Column(name = "id_patio")
    private Long idPatio;
}
