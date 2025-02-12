package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "imoveis")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Imoveis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_proprietario", nullable = false)
    private Clientes proprietario;

    @ManyToOne
    @JoinColumn(name = "id_tipo_imovel", nullable = false)
    private Tipo_imovel tipo_imovel;

    @Column(nullable = false, length = 200)
    private String logradouro;

    @Column(nullable = false, length = 45)
    private String bairro;

    @Column(nullable = false, length = 10)
    private String cep;

    private Integer metragem;
    private int dormitorios;
    private int banheiros;
    private int suites;
    private int vagasGaragem;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorAluguelSugerido;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @Column(nullable = false)
    private boolean disponivel; // 🔥 Adicionado campo para indicar disponibilidade
}
