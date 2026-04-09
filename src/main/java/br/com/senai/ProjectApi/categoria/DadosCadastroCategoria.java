package br.com.senai.ProjectApi.categoria;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroCategoria(

        @NotBlank
        @Size(min =3, max = 60)
        @Column(unique = true)
        String nome,

        @Size(max = 255)
        String descricao
) {
}
