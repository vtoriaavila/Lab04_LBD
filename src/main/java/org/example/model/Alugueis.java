package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Alugueis")  // Mantido "Alugueis" conforme a versão mais recente
@NoArgsConstructor
@AllArgsConstructor
public class Alugueis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_locacao", nullable = false)
    private Locacao locacao;

    @NonNull
    @Column(nullable = false)
    private LocalDate dataVencimento;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorPago;

    private LocalDate dataPagamento;

    @Column(columnDefinition = "TEXT")
    private String observacao;
}
