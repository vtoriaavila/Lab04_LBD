package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.model.Alugueis;
import org.example.repository.AluguelRepository;
import org.example.util.JPAUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class RegistrarPagamentoService {

    private static final BigDecimal MULTA_DIARIA = new BigDecimal("0.0033"); // 0,33% ao dia
    private static final BigDecimal MULTA_MAXIMA = new BigDecimal("0.20"); // Limite de 20%
    private final AluguelRepository aluguelRepository;
    private final EntityManager manager;

    public RegistrarPagamentoService() {
        this.manager = JPAUtil.getEntityManager();
        this.aluguelRepository = new AluguelRepository();
    }

    public void registrarPagamento(Integer idAluguel, BigDecimal valorPago, LocalDate dataPagamento) {
        manager.getTransaction().begin();

        Alugueis aluguel = aluguelRepository.buscarPorId(idAluguel);
        if (aluguel == null) {
            manager.getTransaction().rollback();
            throw new IllegalArgumentException("Aluguel não encontrado.");
        }

        BigDecimal valorFinal = calcularValorComMulta(aluguel, dataPagamento);
        aluguel.setValorPago(valorFinal);
        aluguel.setDataPagamento(dataPagamento);

        aluguelRepository.atualizar(aluguel);
        manager.getTransaction().commit();

        System.out.println("Pagamento registrado com sucesso. Valor pago: " + valorFinal);
    }

    private BigDecimal calcularValorComMulta(Alugueis aluguel, LocalDate dataPagamento) {
        if (aluguel.getDataVencimento() == null || aluguel.getValorPago() == null) {
            return BigDecimal.ZERO;
        }

        long diasAtraso = ChronoUnit.DAYS.between(aluguel.getDataVencimento(), dataPagamento);
        if (diasAtraso > 0) {
            BigDecimal multa = aluguel.getValorPago().multiply(MULTA_DIARIA).multiply(BigDecimal.valueOf(diasAtraso));
            if (multa.compareTo(aluguel.getValorPago().multiply(MULTA_MAXIMA)) > 0) {
                multa = aluguel.getValorPago().multiply(MULTA_MAXIMA);
            }
            return aluguel.getValorPago().add(multa);
        }
        return aluguel.getValorPago();
    }
}
