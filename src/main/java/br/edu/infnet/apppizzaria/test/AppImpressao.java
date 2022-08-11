package br.edu.infnet.apppizzaria.test;

import br.edu.infnet.apppizzaria.interfaces.IPrinter;

public class AppImpressao {
	
	public static void relatorio(String mensagem, IPrinter printer) {		
		System.out.println(mensagem);
		
		printer.impressao();		
	}

}
