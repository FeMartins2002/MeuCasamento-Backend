package br.com.MeuCasamento.exceptions;

public class SpouseLimitExceededException extends BusinessException {
    public SpouseLimitExceededException(String message) {
        super(message);
    }
}
