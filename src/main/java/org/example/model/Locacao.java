package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Locacao")
public class Locacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne
    private Imoveis imovel;

    @NonNull
    @ManyToOne
    private Clientes inquilino;

    @NonNull
    @Column(nullable = false)
    private float valor_aluguel;

    private float percentual_multa;

    @NonNull
    @Column(nullable = false)
    private Date dia_vencimento;

    @NonNull
    @Column(nullable = false)
    private Date data_inicio;

    private Date data_fim;

    @NonNull
    @Column(nullable = false)
    private Boolean ativo;

    private String obs;

}
