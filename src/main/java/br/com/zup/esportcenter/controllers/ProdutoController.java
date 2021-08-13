package br.com.zup.esportcenter.controllers;

import br.com.zup.esportcenter.dtos.ProdutoDTO;
import br.com.zup.esportcenter.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    // Mètodo para cadastrar produto
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDTO cadastrarProduto(@RequestBody ProdutoDTO produto){
        return produtoService.cadastrarProduto(produto);
    }
    // Método para buscar todos os produtos cadastrados
    @GetMapping
    public List<ProdutoDTO> buscarProdutosCadastrados(){
        return produtoService.mostrarListaDeProdutos();
    }
}

