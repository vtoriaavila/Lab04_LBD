package org.example.test;

import org.example.model.Clientes;
import org.example.repository.ClienteRepository;

import java.util.List;

public class TesteClienteRepository {
    public static void main(String[] args) {
        ClienteRepository repo = new ClienteRepository();

        // Criar e salvar um cliente
        Clientes cliente = new Clientes();
        cliente.setNome("Carlos Silva");
        cliente.setCpf("12345678900");

        if (!repo.cpfJaCadastrado(cliente.getCpf())) {
            repo.salvar(cliente);
            System.out.println("Cliente cadastrado!");
        } else {
            System.out.println("CPF já cadastrado!");
        }

        // Listar todos os clientes
        List<Clientes> clientes = repo.listarTodos();
        System.out.println("Lista de clientes: " + clientes);
    }
}
