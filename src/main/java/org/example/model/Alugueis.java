package org.example.model;

import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.util.Date;

@Entity
public class Alugueis {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Locacao id_locacao;

    @Column(nullable = false)
    private Date data_vencimento;
    private float valor_pago;
    private Date data_pagamento;
    private String obs;
}
