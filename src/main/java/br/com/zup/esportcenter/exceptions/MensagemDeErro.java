package br.com.zup.esportcenter.exceptions;

public class MensagemDeErro {
    private int statusCode;
    private Erro erro;

    public MensagemDeErro(int statusCode, Erro erro) {
        this.statusCode = statusCode;
        this.erro = erro;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Erro getErros() {
        return erro;
    }

    public void setErros(Erro erro) {
        this.erro = erro;
    }
}
