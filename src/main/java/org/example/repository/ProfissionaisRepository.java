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

    public void atualizar(Profissionais profissional) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(profissional);
        em.getTransaction().commit();
        em.close();
    }

    public Profissionais buscarPorId(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Profissionais.class, id);
    }

    public void remover(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        Profissionais profissional = em.find(Profissionais.class, id);
        if (profissional != null) {
            em.getTransaction().begin();
            em.remove(profissional);
            em.getTransaction().commit();
        }
        em.close();
    }

    public List<Profissionais> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Profissionais> query = em.createQuery(
                "SELECT p FROM Profissionais p", Profissionais.class);
        return query.getResultList();
    }
}
