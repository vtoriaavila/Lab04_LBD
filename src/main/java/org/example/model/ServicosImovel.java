package org.example.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Servicos_Imovel")
public class ServicosImovel {
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
