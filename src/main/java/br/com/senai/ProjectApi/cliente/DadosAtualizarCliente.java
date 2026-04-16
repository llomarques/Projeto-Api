package br.com.senai.ProjectApi.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAtualizarCliente(
        @NotNull
        Long id,

        @Size(min = 3, max = 100)
        String nome,

        @Email
        String email,

        @Size(max = 20)
        String telefone
) {
}
