package br.com.MeuCasamento.exceptions;

import java.util.UUID;

public class PartyNotFoundException extends BusinessException{
    public PartyNotFoundException(String message) {
        super(message);
    }
}
