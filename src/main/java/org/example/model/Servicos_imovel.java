package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "servicos_imovel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servicos_imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_profissional", nullable = false)
    private Profissionais profissional;

    @ManyToOne
    @JoinColumn(name = "id_imovel", nullable = false)
    private Imoveis imovel;

    @Column(nullable = false)
    private LocalDate dataServico;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(columnDefinition = "TEXT")
    private String observacao;
}
