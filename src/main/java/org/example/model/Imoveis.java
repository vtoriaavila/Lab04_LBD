package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "Imoveis")
@NoArgsConstructor
@AllArgsConstructor
public class Imoveis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_proprietario", nullable = false)
    private Clientes proprietario;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_tipo_imovel", nullable = false)
    private TipoImovel tipoImovel;

    @NonNull
    @Column(nullable = false, length = 200)
    private String logradouro;

    @NonNull
    @Column(nullable = false, length = 45)
    private String bairro;

    @NonNull
    @Column(nullable = false, length = 10)
    private String cep;

    @Column(nullable = false)
    private Integer metragem;

    @Column(nullable = false)
    private int dormitorios;

    @Column(nullable = false)
    private int banheiros;

    @Column(nullable = false)
    private int suites;

    @Column(nullable = false)
    private int vagasGaragem;

    @NonNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorAluguelSugerido;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @Column(nullable = false)
    private boolean disponivel;
}
