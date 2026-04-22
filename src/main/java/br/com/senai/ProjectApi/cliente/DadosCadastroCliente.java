package br.com.senai.ProjectApi.cliente;

import br.com.senai.ProjectApi.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroCliente(
        @NotBlank
        @Size(min = 3, max = 100)
        String nome,

        @NotBlank
        @Email
        String email,

        @CPF
        @NotBlank
        String cpf,

        @Size(max = 20)
        String telefone,

        @NotNull
        @Valid
        DadosEndereco endereco
) {
}
