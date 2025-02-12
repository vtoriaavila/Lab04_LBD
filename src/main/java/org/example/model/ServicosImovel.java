package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Servicos_Imovel")  // Nome da tabela corrigido para "Servicos_Imovel"
@NoArgsConstructor
@AllArgsConstructor
public class ServicosImovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_profissional", nullable = false)
    private Profissionais profissional;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_imovel", nullable = false)
    private Imoveis imovel;

    @NonNull
    @Column(nullable = false)
    private LocalDate dataServico;

    @NonNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(columnDefinition = "TEXT")
    private String observacao;
}
