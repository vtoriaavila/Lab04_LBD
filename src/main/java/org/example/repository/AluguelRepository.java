package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.Alugueis;
import org.example.model.Locacao;
import org.example.util.JPAUtil;

import java.util.List;

public class AluguelRepository {

    public void salvar(Alugueis aluguel) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Locacao locacao = em.find(Locacao.class, aluguel.getLocacao().getId());
        if (locacao == null) {
            throw new IllegalArgumentException("A locação com o ID " + aluguel.getLocacao().getId() + " não existe.");
        }
        em.persist(aluguel);
        em.getTransaction().commit();
        em.close();
    }

    public void atualizar(Alugueis aluguel) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(aluguel);
        em.getTransaction().commit();
        em.close();
    }

    public Alugueis buscarPorId(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Alugueis.class, id);
    }

    public void remover(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        Alugueis aluguel = em.find(Alugueis.class, id);
        if (aluguel != null) {
            em.getTransaction().begin();
            em.remove(aluguel);
            em.getTransaction().commit();
        }
        em.close();
    }

    public List<Alugueis> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Alugueis> query = em.createQuery(
                "SELECT a FROM Alugueis a", Alugueis.class);
        return query.getResultList();
    }

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
