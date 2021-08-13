package br.com.zup.esportcenter.services;

import br.com.zup.esportcenter.dtos.ClienteDTO;
import br.com.zup.esportcenter.dtos.CompraDTO;
import br.com.zup.esportcenter.dtos.ProdutoDTO;
import br.com.zup.esportcenter.exceptions.ProdutoComEstoqueVazio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CompraService {
    private List<CompraDTO> listaDeCompras = new ArrayList<>();

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    // Método para cadastrar compras
    public CompraDTO cadastrarCompras(CompraDTO compraDTO) {

        List<ProdutoDTO> produtos = compraDTO.getProdutos();
        List<ProdutoDTO> objetoProdutos = new ArrayList<>();
        List<ProdutoDTO> produtosSemEstoque = new ArrayList<>();


        ClienteDTO objetoCli = clienteService.buscarClientesPorCpf(compraDTO.getCliente().getCpf());
        compraDTO.setCliente(objetoCli);

        for (ProdutoDTO produto: produtos) {
            ProdutoDTO objeto = produtoService.buscarPorNome(produto.getNome());
            if (objeto.getQuantidade()<=0){
                produtosSemEstoque.add(objeto);
                throw new ProdutoComEstoqueVazio("Não é possivel comprar pois o produto "+produto.getNome()+" está indisponivel no estoque ");
            }
            objetoProdutos.add(objeto);
        }

        compraDTO.setProdutos(objetoProdutos);
        listaDeCompras.add(compraDTO);
        return compraDTO;
    }
    // Método para listar compras
    public List<CompraDTO> mostrarCompras() {
        return listaDeCompras;
    }


}

