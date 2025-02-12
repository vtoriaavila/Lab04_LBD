package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "Profissionais")  // Mantido "Profissionais" conforme a versão mais recente
@NoArgsConstructor
@AllArgsConstructor
public class Profissionais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false, length = 45)
    private String nome;

    @NonNull
    @Column(nullable = false, length = 45)
    private String profissao;

    @NonNull
    @Column(nullable = false, unique = true, length = 12)  // Mantido o telefone com a restrição unique
    private String telefone1;  // Alterado de "telefone" para "telefone1" conforme a versão mais recente

    @NonNull
    @Column(nullable = false, length = 12)
    private String celular;

    @NonNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorHora;

    @Column(columnDefinition = "TEXT")
    private String observacao;
}
