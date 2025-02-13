package org.example.test;

import org.example.model.Imoveis;
import org.example.repository.ImovelRepository;

import java.math.BigDecimal;
import java.util.List;

public class TesteImovelRepository {
    public static void main(String[] args) {
        ImovelRepository repo = new ImovelRepository();

        // Criar e salvar um imóvel
        // Criar e salvar um imóvel
        Imoveis imovel = new Imoveis();
        imovel.setLogradouro("Rua das Flores, 123");  // Corrigido de setEndereco() para setLogradouro()
        imovel.setValorAluguelSugerido(new BigDecimal("1500.00"));
        imovel.setDisponivel(true);
        repo.salvar(imovel);
        System.out.println("Imóvel cadastrado!");

        // Listar todos os imóveis
        List<Imoveis> imoveis = repo.listarTodos();
        System.out.println("Lista de imóveis: " + imoveis);

        // Buscar imóveis disponíveis
        List<Imoveis> disponiveis = repo.buscarDisponiveis();
        System.out.println("Imóveis disponíveis: " + disponiveis);

        // Buscar imóveis por preço máximo
        List<Imoveis> baratos = repo.buscarPorPrecoMaximo(1600.00);
        System.out.println("Imóveis abaixo de R$1600: " + baratos);
    }
}
