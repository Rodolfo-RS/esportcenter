package br.com.zup.esportcenter.exceptions;

public class ClienteDuplicadoException extends RuntimeException{

    public ClienteDuplicadoException(String message) {
        super(message);
    }
}
