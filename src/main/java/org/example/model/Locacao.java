package org.example.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Locacao")
public class Locacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Imoveis imovel;

    @ManyToOne
    private Clientes inquilino;

    @Column(nullable = false)
    private float valor_aluguel;

    private float percentual_multa;

    @Column(nullable = false)
    private Date dia_vencimento;

    @Column(nullable = false)
    private Date data_inicio;

    private Date data_fim;

    @Column(nullable = false)
    private Boolean ativo;

    private String obs;

}
