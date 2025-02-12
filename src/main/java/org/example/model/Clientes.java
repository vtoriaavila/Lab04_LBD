package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "Clientes")
public class Clientes {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @NonNull
    @Column(nullable = false,unique = true)
    private String cpf;

    @NonNull
    @Column(nullable = false,unique = true)
    private String telefone;

    private String email ;
    private Date dt_nascimento;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clientes clientes = (Clientes) o;
        return Objects.equals(id, clientes.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
