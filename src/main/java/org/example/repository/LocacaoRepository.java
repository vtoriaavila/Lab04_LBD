package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    public List<Locacao> listarPorCliente(Long clienteId) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Locacao> query = em.createQuery(
                "SELECT l FROM Locacao l WHERE l.inquilino.id = :clienteId", Locacao.class);
        query.setParameter("clienteId", clienteId);
        return query.getResultList();
    }

    public boolean verificarDisponibilidadeImovel(Long imovelId) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(l) FROM Locacao l WHERE l.imovel.id = :imovelId AND l.ativo = true",
                Long.class);
        query.setParameter("imovelId", imovelId);
        Long count = query.getSingleResult();
        em.close();
        return count == 0;
    }
}
