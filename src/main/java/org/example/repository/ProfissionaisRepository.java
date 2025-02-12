package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.Profissionais;
import org.example.util.JPAUtil;

import java.util.List;

public class ProfissionaisRepository {

    public void salvar(Profissionais profissional) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(profissional);
        em.getTransaction().commit();
        em.close();
    }

    public List<Profissionais> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Profissionais> query = em.createQuery(
                "SELECT p FROM Profissionais p", Profissionais.class);
        return query.getResultList();
    }
}
