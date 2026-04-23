package br.com.senai.ProjectApi.cliente;

import br.com.senai.ProjectApi.endereco.Endereco;

public record DadosDetalhamentoCliente(
        Long id,
        String nome,
        String email,
        String cpf,
        String telefone,
        Endereco endereco




) {
    public DadosDetalhamentoCliente(Cliente cliente) {
        this(cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getCpf(),
                cliente.getTelefone(),
                cliente.getEndereco());

    }
}
