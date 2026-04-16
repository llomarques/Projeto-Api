package br.com.senai.ProjectApi.controller;

import br.com.senai.ProjectApi.categoria.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("categorias")

public class CategoriaController {

    @Autowired //indica para o springboot que ele vai instanciar(criar) esse objeto
    private CategoriaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarCategoria(@RequestBody @Valid DadosCadastroCategoria dados ){
        repository.save(new Categoria(dados));

    }

//    @GetMapping
//    public List<DadosListagemCategoria> listarCategoria(){
//
//        return repository.findAll()
//                .stream()
//                .map(DadosListagemCategoria::new)
//                .toList();
//    }

    @GetMapping
    public Page<DadosListagemCategoria> listarCategoria( @PageableDefault(size=10, sort ={"nome"}) Pageable paginacao){

        return repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemCategoria::new);

    }

    @PutMapping
    @Transactional
    public void atualizarCategoria(@RequestBody @Valid DadosAtualizarCategoria dados ){
        var categoria = repository.getReferenceById(dados.id());
        categoria.atualizarCategoria(dados);

    }

//    @DeleteMapping("/{id}")
//    @Transactional
//    public void deletarCategoria(@PathVariable Long id){
//        repository.deleteById(id
//        );
//    }
    @DeleteMapping("/{id}")
    @Transactional
    public void deletarCategoria(@PathVariable Long id){
        var categoria = repository.getReferenceById(id);
        categoria.excluirCategoria();
    }

    @GetMapping("/{id}")
    public DadosDetalhamentoCategoria detalharCategoria(@PathVariable Long id){
        Categoria categoria = repository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Categoria não existe"
        ));
        return  new DadosDetalhamentoCategoria(categoria);
    }
}
