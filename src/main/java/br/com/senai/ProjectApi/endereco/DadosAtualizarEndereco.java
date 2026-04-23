package br.com.senai.ProjectApi.endereco;

import jakarta.validation.constraints.Pattern;

public record DadosAtualizarEndereco(
        String logradouro,
        String bairro,
        String cidade,

        @Pattern(regexp = "\\d{8}")
        String cep,

        @Pattern(regexp = "^[A-Z]{2}")
        String uf,

        String numero,
        String complemento

) {
}
