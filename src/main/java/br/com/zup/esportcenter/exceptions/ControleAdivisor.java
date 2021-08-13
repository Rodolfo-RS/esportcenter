package br.com.zup.esportcenter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControleAdivisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipularExcecoesDeValidacao(MethodArgumentNotValidException exception){
        FieldError fildErro = exception.getBindingResult().getFieldError();
        /*
        Converte a lista de fildEerros para erros que é a classe customisada que criamos
        Para conversão usamos o Stream para manipular os objetos da lista e o lambida (->)
         */
        Erro erro = new Erro(fildErro.getField());
        return new MensagemDeErro(400, erro);
    }

    /*
    Exception de Produto não encontrado personalizada
     */
    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public MensagemDeErro manipularProdutoNaoEncontrato(ProdutoNaoEncontradoException exception){
        Erro erro = new Erro(exception.getMessage());

        return new MensagemDeErro(400, erro);
    }

    /*
    Exception de Produto Duplicado personalizada
     */
    @ExceptionHandler(ProdutoDuplicadoException.class)
    public MensagemDeErro produtoDuplicado(ProdutoDuplicadoException exception){
        Erro erro = new Erro(exception.getMessage());
        return new MensagemDeErro(400, erro);
    }

    /*
    Exception de Cliente não encontrado personalizada
     */
    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public MensagemDeErro manipularClienteNaoEncontrato(ClienteNaoEncontradoException exception){
        Erro erro = new Erro(exception.getMessage());

        return new MensagemDeErro(400, erro);
    }

    /*
    Exception de Cliente Duplicado personalizada
     */
    @ExceptionHandler(ClienteDuplicadoException.class)
    public MensagemDeErro clienteDuplicado(ClienteDuplicadoException exception) {
        Erro erro = new Erro(exception.getMessage());
        return new MensagemDeErro(400, erro);
    }

    /*
    Exception de Produto com estoque vazio personalizada
     */
    @ExceptionHandler(ProdutoComEstoqueVazio.class)
    public MensagemDeErro produtoComEstoqueVazio(ProdutoComEstoqueVazio exception) {
        Erro erro = new Erro(exception.getMessage());
        return new MensagemDeErro(400, erro);
    }
}
