package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "locacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_imovel", nullable = false)
    private Imoveis imovel;

    @ManyToOne
    @JoinColumn(name = "id_inquilino", nullable = false)
    private Clientes inquilino;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorAluguel;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal percentualMulta;

    @Column(nullable = false)
    private int diaVencimento;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFim;

    @Column(nullable = false)
    private boolean ativo;

    @Column(columnDefinition = "TEXT")
    private String observacao;
}
