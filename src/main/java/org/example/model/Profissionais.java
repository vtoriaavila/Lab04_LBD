package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "profissionais")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profissionais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = false, length = 45)
    private String profissao;

    @Column(nullable = false, length = 12)
    private String telefone;

    @Column(nullable = false, length = 12)
    private String celular;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorHora;

    @Column(columnDefinition = "TEXT")
    private String observacao;
}
