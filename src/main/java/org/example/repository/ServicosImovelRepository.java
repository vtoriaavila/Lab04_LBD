package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.ServicosImovel;
import org.example.util.JPAUtil;

import java.util.List;

public class ServicosImovelRepository {

    public void salvar(ServicosImovel servico) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(servico);
        em.getTransaction().commit();
        em.close();
    }

    public void atualizar(ServicosImovel servico) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(servico);
        em.getTransaction().commit();
        em.close();
    }

    public ServicosImovel buscarPorId(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(ServicosImovel.class, id);
    }

    public void remover(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        ServicosImovel servico = em.find(ServicosImovel.class, id);
        if (servico != null) {
            em.getTransaction().begin();
            em.remove(servico);
            em.getTransaction().commit();
        }
        em.close();
    }

    public List<ServicosImovel> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<ServicosImovel> query = em.createQuery(
                "SELECT s FROM ServicosImovel s", ServicosImovel.class);
        return query.getResultList();
    }

    public List<ServicosImovel> listarPorImovel(Integer idImovel) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<ServicosImovel> query = em.createQuery(
                "SELECT s FROM ServicosImovel s WHERE s.imovel.id = :idImovel", ServicosImovel.class);
        query.setParameter("idImovel", idImovel);
        return query.getResultList();
    }
}
