package br.com.senai.ProjectApi.cliente;


import br.com.senai.ProjectApi.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String telefone;

    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public Cliente (DadosCadastroCliente dados ){
      this.nome = dados.nome();
      this.email =  dados.email();
      this.cpf = dados.cpf();
      this.telefone = dados.telefone();
      this.ativo = true;
      this.endereco= new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizarCliente dados){
        if (dados.nome() != null && !dados.nome().isBlank())
            this.nome = dados.nome();
        if (dados.email() != null && !dados.email().isBlank())
            this.email= dados.email();
        if (dados.telefone() != null && !dados.telefone().isBlank())
            this.telefone = dados.telefone();
    }

    public void excluirCliente(){
        this.ativo = false;
    }

}
