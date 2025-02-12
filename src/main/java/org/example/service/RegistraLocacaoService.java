package org.example.service;


import org.example.model.Clientes;
import org.example.model.Imoveis;
import org.example.model.Locacao;
import org.example.repository.LocacaoRepository;
import org.example.util.JPAUtil;

import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;

public class RegistraLocacaoService {

    private final LocacaoRepository repositorio;
    private final EntityManager manager;

    public RegistraLocacaoService() {
        this.manager = JPAUtil.getEntityManager();
        this.repositorio = new LocacaoRepository();
    }

    public Locacao registrar(Clientes inquilino, Imoveis imovel, LocalDate dataInicio, LocalDate dataFim, BigDecimal valorAluguel) {

        manager.getTransaction().begin();

        // Verifica se o imóvel está disponível para locação
        boolean disponivel = repositorio.verificarDisponibilidadeImovel(imovel);
        if (!disponivel) {
            manager.getTransaction().rollback();
            throw new IllegalArgumentException("O imóvel já está alugado!");
        }

        // Cria e configura a nova locação
        Locacao locacao = new Locacao();
        locacao.setImovel(imovel);
        locacao.setInquilino(inquilino);
        locacao.setDataInicio(dataInicio);
        locacao.setDataFim(dataFim);
        locacao.setValorAluguel(valorAluguel);
        locacao.setAtivo(true);

        // Salva a locação no banco de dados
        repositorio.salvar(locacao);


        manager.merge(imovel);

        manager.getTransaction().commit();

        return locacao;
    }
}
