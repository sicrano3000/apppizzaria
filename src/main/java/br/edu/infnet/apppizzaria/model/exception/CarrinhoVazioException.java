package br.edu.infnet.apppizzaria.model.exception;

public class CarrinhoVazioException extends Exception {
	
	static final long serialVersionUID = 1L;
	
	public CarrinhoVazioException(String mensagem) {
		super(mensagem);
	}

}
