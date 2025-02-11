package org.example.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Profissionais {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column (unique = true)
    private String nome;

    @Column (unique = true)
    private String profissao;

    @Column (unique = true)
    private String telefone1;

    private String telefone2;
    private float valor_hora;
    private String OBS;

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

    public String getOBS() {
        return OBS;
    }

    public void setOBS(String OBS) {
        this.OBS = OBS;
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
