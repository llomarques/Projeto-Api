package br.com.senai.ProjectApi.produto;

import br.com.senai.ProjectApi.categoria.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String nome;
    private BigDecimal preco;
    private String sku;
    private String descricao;
    private Long estoque;
    private boolean ativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Produto(DadosCadastroProduto dados, Categoria categoria){
        this.nome = dados.nome();
        this.preco = dados.preco();
        this.sku = dados.sku();
        this.descricao = dados.descricao();
        this.estoque = dados.estoque();
        this.categoria = categoria;
        this.ativo = true;
    }

    public void excluirProduto(){
        this.ativo = false;
    }
}
