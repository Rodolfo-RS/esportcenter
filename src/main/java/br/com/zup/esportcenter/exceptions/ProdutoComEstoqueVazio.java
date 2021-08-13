package br.com.zup.esportcenter.exceptions;

public class ProdutoComEstoqueVazio extends RuntimeException{

    public ProdutoComEstoqueVazio(String message) {
        super(message);
    }
}
