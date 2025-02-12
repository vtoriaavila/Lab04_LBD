package org.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_imovel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tipo_imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 256)
    private String descricao;
}
