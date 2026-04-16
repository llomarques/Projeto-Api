package br.com.senai.ProjectApi.categoria;

public record DadosDetalhamentoCategoria(
        Long id,
        String nome,
        String descricao

) {


    public DadosDetalhamentoCategoria(Categoria categoria) {
        this(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }
}
