package br.com.MeuCasamento.exceptions;

public class InvalidPasswordException extends BusinessException{
    public InvalidPasswordException(String message) {
        super(message);
    }
}
