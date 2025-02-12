package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "Profissionais")
public class Profissionais {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NonNull
    @Column (nullable = false)
    private String nome;

    @NonNull
    @Column (nullable = false)
    private String profissao;

    @NonNull
    @Column (nullable = false,unique = true)
    private String telefone1;

    private String telefone2;
    private float valor_hora;
    private String obs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public float getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(float valor_hora) {
        this.valor_hora = valor_hora;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String OBS) {
        this.obs = OBS;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Profissionais that = (Profissionais) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
