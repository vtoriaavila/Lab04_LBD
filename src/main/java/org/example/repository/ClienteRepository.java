package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.Clientes;
import org.example.util.JPAUtil;

import java.util.List;

public class ClienteRepository {

    public void salvar(Clientes cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public boolean cpfJaCadastrado(String cpf) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(c) FROM Clientes c WHERE c.cpf = :cpf", Long.class);
        query.setParameter("cpf", cpf);
        Long count = query.getSingleResult();
        em.close();
        return count > 0;
    }

    public List<Clientes> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Clientes> query = em.createQuery(
                "SELECT c FROM Clientes c", Clientes.class);
        return query.getResultList();
    }

    public Clientes buscarPorId(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Clientes.class, id);
    }

    public void atualizar(Clientes cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        Clientes cliente = em.find(Clientes.class, id);
        if (cliente != null) {
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        }
        em.close();
    }
}
