package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.Alugueis;
import org.example.util.JPAUtil;

import java.util.List;

public class AluguelRepository {

    public List<Alugueis> listarPorCliente(String nomeCliente) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Alugueis> query = em.createQuery(
                "SELECT a FROM Alugueis a WHERE a.locacao.inquilino.nome LIKE :nomeCliente",
                Alugueis.class
        );
        query.setParameter("nomeCliente", "%" + nomeCliente + "%");
        return query.getResultList();
    }

    public List<Alugueis> listarAtrasados() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Alugueis> query = em.createQuery(
                "SELECT a FROM Alugueis a WHERE a.dataPagamento > a.dataVencimento",
                Alugueis.class);
        return query.getResultList();
    }
}
