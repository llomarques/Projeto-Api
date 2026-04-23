package br.com.senai.ProjectApi.endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Endereco {
    private String logradouro;
    private String bairro;
    private String cidade;
    private String cep;
    private String numero;
    private String complemento;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.cep= dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.uf = dados.uf();

    }

    public void atualizarEndereco(@Valid DadosAtualizarEndereco dados) {
        if (dados.logradouro() != null && !dados.logradouro().isBlank())
            this.logradouro = dados.logradouro();
        if (dados.bairro() != null && !dados.bairro().isBlank())
            this.bairro = dados.bairro();
        if (dados.cidade() != null && !dados.cidade().isBlank())
            this.cidade = dados.cidade();
        if (dados.cep() != null && !dados.cep().isBlank())
            this.cep = dados.cep();
        if (dados.numero() != null && !dados.numero().isBlank())
            this.numero = dados.numero();
        if (dados.complemento() != null && !dados.complemento().isBlank())
            this.complemento = dados.complemento();
        if (dados.uf() != null && !dados.uf().isBlank())
            this.uf = dados.uf();

    }
}
