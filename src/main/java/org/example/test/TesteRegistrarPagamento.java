package org.example.test;

import org.example.service.RegistrarPagamentoService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TesteRegistrarPagamento {
    public static void main(String[] args) {
        RegistrarPagamentoService service = new RegistrarPagamentoService();

        // Registrar um pagamento
        Integer idAluguel = 1;
        BigDecimal valorPago = new BigDecimal("1500.00");
        LocalDate dataPagamento = LocalDate.now().plusDays(2);

        service.registrarPagamento(idAluguel, valorPago, dataPagamento);
    }
}
