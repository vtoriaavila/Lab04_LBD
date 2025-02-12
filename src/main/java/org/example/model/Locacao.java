package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Locacao")  // Mantido "Locacao" conforme a versão mais recente
@NoArgsConstructor
@AllArgsConstructor
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_imovel", nullable = false)
    private Imoveis imovel;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_inquilino", nullable = false)
    private Clientes inquilino;

    @NonNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorAluguel;  // Mantido tipo BigDecimal para o valor do aluguel

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal percentualMulta;

    @NonNull
    @Column(nullable = false)
    private int diaVencimento;

    @NonNull
    @Column(nullable = false)
    private LocalDate dataInicio;

    @NonNull
    @Column(nullable = false)
    private LocalDate dataFim;

    @Column(nullable = false)
    private boolean ativo;

    @Column(columnDefinition = "TEXT")
    private String observacao;
}
