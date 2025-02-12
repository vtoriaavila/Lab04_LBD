package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.Servicos_imovel;
import org.example.util.JPAUtil;

import java.util.List;

public class ServicosImovelRepository {

    public void salvar(Servicos_imovel servico) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(servico);
        em.getTransaction().commit();
        em.close();
    }

    public List<Servicos_imovel> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Servicos_imovel> query = em.createQuery(
                "SELECT s FROM Servicos_imovel s", Servicos_imovel.class);
        return query.getResultList();
    }
}
