package org.example.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class Servicos_imovel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Profissionais id_profissional;

    @ManyToOne
    private Imoveis id_imovel;

    private Date data_servico;
    private float valor_total;
    private String text;

}
