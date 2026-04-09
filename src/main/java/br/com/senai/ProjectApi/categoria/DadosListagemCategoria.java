package br.com.senai.ProjectApi.categoria;

public record DadosListagemCategoria(
        Long id,
        String nome

) {
    public DadosListagemCategoria(Categoria categoria){
        this(categoria.getId(), categoria.getNome());
    }

}
