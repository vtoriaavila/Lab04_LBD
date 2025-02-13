package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.Imoveis;
import org.example.util.JPAUtil;

import java.util.List;

public class ImovelRepository {

    public void salvar(Imoveis imovel) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(imovel);
        em.getTransaction().commit();
        em.close();
    }

    public List<Imoveis> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Imoveis> query = em.createQuery(
                "SELECT i FROM Imoveis i", Imoveis.class);
        return query.getResultList();
    }

    public List<Imoveis> buscarDisponiveis() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Imoveis> query = em.createQuery(
                "SELECT i FROM Imoveis i WHERE i.disponivel = true", Imoveis.class);
        return query.getResultList();
    }

    public List<Imoveis> buscarPorPrecoMaximo(Double preco) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Imoveis> query = em.createQuery(
                "SELECT i FROM Imoveis i WHERE i.valorAluguelSugerido <= :preco AND i.disponivel = true",
                Imoveis.class);
        query.setParameter("preco", preco);
        return query.getResultList();
    }

    public Imoveis buscarPorId(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Imoveis.class, id);
    }

    public void atualizar(Imoveis imovel) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(imovel);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        Imoveis imovel = em.find(Imoveis.class, id);
        if (imovel != null) {
            em.getTransaction().begin();
            em.remove(imovel);
            em.getTransaction().commit();
        }
        em.close();
    }
}
