package org.example.test;

import org.example.model.Alugueis;
import org.example.model.Locacao;
import org.example.repository.AluguelRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TesteAluguelRepository {
    public static void main(String[] args) {
        AluguelRepository repo = new AluguelRepository();

        // Criar um aluguel fictício
        Locacao locacao = new Locacao();
        locacao.setId(0);

        Alugueis aluguel = new Alugueis();
        aluguel.setLocacao(locacao);
        aluguel.setDataVencimento(LocalDate.now().plusDays(5));
        aluguel.setValorPago(new BigDecimal("1500.00"));
        aluguel.setDataPagamento(LocalDate.now());        // Definir data de pagamento
        aluguel.setObservacao("Aluguel referente ao mês de fevereiro.");  // Definir observação
        repo.salvar(aluguel);
        System.out.println("Aluguel registrado!");

        // Listar aluguéis de um cliente
        List<Alugueis> alugueisCliente = repo.listarPorCliente("Carlos Silva");
        System.out.println("Aluguéis do cliente: " + alugueisCliente);

        // Listar aluguéis atrasados
        List<Alugueis> alugueisAtrasados = repo.listarAtrasados();
        System.out.println("Aluguéis em atraso: " + alugueisAtrasados);
    }
}
