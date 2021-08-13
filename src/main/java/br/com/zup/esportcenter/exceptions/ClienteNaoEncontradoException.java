package br.com.zup.esportcenter.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException{

    public ClienteNaoEncontradoException(String message) {
        super(message);
    }
}
