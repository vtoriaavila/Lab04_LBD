package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.Imoveis;
import org.example.model.Locacao;
import org.example.util.JPAUtil;

import java.util.List;

public class LocacaoRepository {

    public void salvar(Locacao locacao) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(locacao);
        em.getTransaction().commit();
        em.close();
    }

    public void atualizar(Locacao locacao) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(locacao);
        em.getTransaction().commit();
        em.close();
    }

    public Locacao buscarPorId(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Locacao.class, id);
    }

    public void remover(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        Locacao locacao = em.find(Locacao.class, id);
        if (locacao != null) {
            em.getTransaction().begin();
            em.remove(locacao);
            em.getTransaction().commit();
        }
        em.close();
    }

    public List<Locacao> listarTodas() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Locacao> query = em.createQuery(
                "SELECT l FROM Locacao l", Locacao.class);
        return query.getResultList();
    }

    public List<Locacao> listarPorCliente(Long clienteId) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Locacao> query = em.createQuery(
                "SELECT l FROM Locacao l WHERE l.inquilino.id = :clienteId", Locacao.class);
        query.setParameter("clienteId", clienteId);
        return query.getResultList();
    }

    public boolean verificarDisponibilidadeImovel(Imoveis imovel) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(l) FROM Locacao l WHERE l.imovel.id = :imovelId AND l.ativo = true",
                Long.class);
        query.setParameter("imovelId", imovel.getId());
        Long count = query.getSingleResult();
        em.close();
        return count == 0;
    }
}
