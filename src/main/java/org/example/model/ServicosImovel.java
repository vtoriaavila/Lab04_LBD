package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Servicos_Imovel")
public class ServicosImovel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne
    private Profissionais id_profissional;

    @NonNull
    @ManyToOne
    private Imoveis id_imovel;

    private Date data_servico;
    private float valor_total;
    private String text;

}
