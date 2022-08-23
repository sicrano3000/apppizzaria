package br.edu.infnet.apppizzaria.model.exception;

public class ValorNegativoException extends Exception {
	
	static final long serialVersionUID = 1L;
	
	public ValorNegativoException(String mensagem) {
		super(mensagem);
	}

}
