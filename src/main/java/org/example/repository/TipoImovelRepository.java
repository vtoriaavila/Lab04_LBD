package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.TipoImovel;
import org.example.util.JPAUtil;

import java.util.List;

public class TipoImovelRepository {

    public void salvar(TipoImovel tipoImovel) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(tipoImovel);
        em.getTransaction().commit();
        em.close();
    }

    public List<TipoImovel> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<TipoImovel> query = em.createQuery(
                "SELECT t FROM TipoImovel t", TipoImovel.class);
        return query.getResultList();
    }

    public TipoImovel buscarPorId(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(TipoImovel.class, id);
    }

    public void atualizar(TipoImovel tipoImovel) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(tipoImovel);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        TipoImovel tipoImovel = em.find(TipoImovel.class, id);
        if (tipoImovel != null) {
            em.getTransaction().begin();
            em.remove(tipoImovel);
            em.getTransaction().commit();
        }
        em.close();
    }
}
