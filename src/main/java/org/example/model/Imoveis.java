package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Imoveis")
public class Imoveis {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Clientes id_proprietario;

    @ManyToOne
    private TipoImovel id_tipo_imovel;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String bairro;

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
