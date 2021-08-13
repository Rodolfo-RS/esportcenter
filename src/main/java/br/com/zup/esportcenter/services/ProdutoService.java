package br.com.zup.esportcenter.services;

import br.com.zup.esportcenter.dtos.ProdutoDTO;
import br.com.zup.esportcenter.exceptions.ProdutoDuplicadoException;
import br.com.zup.esportcenter.exceptions.ProdutoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProdutoService {
    private List<ProdutoDTO> listaDeProdutos = new ArrayList<>();

    // Método para cadastrar produtos
        public ProdutoDTO cadastrarProduto(ProdutoDTO produto){
            validaProdutoDuplicado(produto);
            listaDeProdutos.add(produto);
            return produto;
    }
    // Método para validar produto cadastrado
    public void validaProdutoDuplicado(ProdutoDTO produtoDTO){
        for (ProdutoDTO item:listaDeProdutos) {
            if (item.getNome().equals(produtoDTO.getNome())){
                throw new ProdutoDuplicadoException("Produto duplicado!");
            }

        }
    }
    // Método para mostrar produtos cadastrados na lista
    public List<ProdutoDTO> mostrarListaDeProdutos(){
            return listaDeProdutos;
    }

    //Metodo para buscar produto pelo nome
    public ProdutoDTO buscarPorNome(String nome){
        for (ProdutoDTO prod: listaDeProdutos) {
           if (prod.getNome().equals(nome)){
               return prod;
           }
        }
        throw new ProdutoNaoEncontradoException("Produto não encontrado!!");
    }

}
