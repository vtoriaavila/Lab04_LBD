package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "Clientes")  // Ajustei para a versão final do nome da tabela
@NoArgsConstructor
@AllArgsConstructor
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false, length = 45)  // Mantido o comprimento de 45 para o nome
    private String nome;

    @NonNull
    @Column(nullable = false, unique = true, length = 15)  // Mantido o comprimento de 15 para o CPF
    private String cpf;

    @NonNull
    @Column(nullable = false, length = 12)  // Mantido o comprimento de 12 para o telefone
    private String telefone;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private LocalDate dtNascimento;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clientes clientes = (Clientes) o;
        return Objects.equals(id, clientes.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
