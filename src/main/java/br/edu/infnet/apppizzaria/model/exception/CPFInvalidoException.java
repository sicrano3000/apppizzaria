package br.edu.infnet.apppizzaria.model.exception;

public class CPFInvalidoException extends Exception {
	
	static final long serialVersionUID = 1L;
	
	public CPFInvalidoException(String mensagem) {
		super(mensagem);
	}

}
