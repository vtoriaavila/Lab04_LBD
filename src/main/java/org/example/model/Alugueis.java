package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Alugueis")
public class Alugueis {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne
    private Locacao id_locacao;

    @NonNull
    @Column(nullable = false)
    private Date data_vencimento;
    private float valor_pago;
    private Date data_pagamento;
    private String obs;
}
