package br.com.zup.esportcenter.dtos;

import java.util.List;

public class CompraDTO {
    private ClienteDTO cliente;
    private List<ProdutoDTO> produtos;

    public CompraDTO() {
    }

    public CompraDTO(ClienteDTO cliente, List<ProdutoDTO> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }
}
