package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Imoveis")
public class Imoveis {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne
    private Clientes id_proprietario;

    @NonNull
    @ManyToOne
    private TipoImovel id_tipo_imovel;

    @NonNull
    @Column(nullable = false)
    private String logradouro;

    @NonNull
    @Column(nullable = false)
    private String bairro;

    @NonNull
    @Column(nullable = false)
    private String cep;

    private Integer metragem;
    private int dormitorio;
    private int banheiros;
    private int suites;
    private int vagas_garagem;
    private float valor_aluguel_sugerido;
    private String obs;
}
