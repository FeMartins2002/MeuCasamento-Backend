package br.com.MeuCasamento.exceptions;

public abstract class BusinessException extends RuntimeException {
	public BusinessException(String message){
		super(message);
	}
}
