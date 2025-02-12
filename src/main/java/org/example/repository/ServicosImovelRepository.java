package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.ServicosImovel;
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

    public List<ServicosImovel> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<ServicosImovel> query = em.createQuery(
                "SELECT s FROM ServicosImovel s", ServicosImovel.class);
        return query.getResultList();
    }
}
