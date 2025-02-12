package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "Imoveis")  // Mantido "Imoveis" conforme a versão mais recente
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
    private TipoImovel tipoImovel;  // Corrigido o nome para "tipoImovel" (estava como "id_tipo_imovel")

    @NonNull
    @Column(nullable = false, length = 200)
    private String logradouro;

    @NonNull
    @Column(nullable = false, length = 45)
    private String bairro;

    @NonNull
    @Column(nullable = false, length = 10)
    private String cep;

    private Integer metragem;
    private int dormitorios;
    private int banheiros;
    private int suites;
    private int vagasGaragem;

    @NonNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorAluguelSugerido;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @Column(nullable = false)
    private boolean disponivel; // Campo para indicar a disponibilidade do imóvel
}
