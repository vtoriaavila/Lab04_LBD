package org.example.test;

import org.example.model.Clientes;
import org.example.model.Imoveis;
import org.example.model.Locacao;
import org.example.repository.LocacaoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TesteLocacaoRepository {
    public static void main(String[] args) {
        LocacaoRepository repo = new LocacaoRepository();

        // Criando um cliente e um imóvel fictício
        Clientes cliente = new Clientes();
        cliente.setId(1);

        Imoveis imovel = new Imoveis();
        imovel.setId(1);
        imovel.setDisponivel(true);

        // Verificar disponibilidade do imóvel
        if (repo.verificarDisponibilidadeImovel(imovel)) {
            // Criar uma locação
            Locacao locacao = new Locacao();
            locacao.setInquilino(cliente);
            locacao.setImovel(imovel);
            locacao.setDataInicio(LocalDate.now());
            locacao.setDataFim(LocalDate.now().plusMonths(12));
            locacao.setValorAluguel(new BigDecimal("1500.00"));
            locacao.setPercentualMulta(new BigDecimal("5.00")); // Valor do percentual de multa
            locacao.setAtivo(true);
            repo.salvar(locacao);
            System.out.println("Locação registrada!");
        } else {
            System.out.println("Imóvel já alugado!");
        }

        // Listar todas as locações de um cliente
        List<Locacao> locacoes = repo.listarPorCliente(1L);
        System.out.println("Locações do cliente: " + locacoes);
    }
}
