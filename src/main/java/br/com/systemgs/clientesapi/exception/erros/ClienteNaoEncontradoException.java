package br.com.systemgs.clientesapi.exception.erros;

public class ClienteNaoEncontradoException  extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ClienteNaoEncontradoException() {
        super("Cliente não Encontrado!");
    }
}
