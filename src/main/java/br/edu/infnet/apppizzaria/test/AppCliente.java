package br.edu.infnet.apppizzaria.test;

import br.edu.infnet.apppizzaria.model.domain.Massa;

public class AppCliente {
		
	private String mensagem;
	
	public AppCliente(String menagem) {
		this.mensagem = menagem;
	}
	
	public void relatorio(Massa massa) {		
		System.out.println(mensagem);
		
		massa.impressao();		
	}

}
