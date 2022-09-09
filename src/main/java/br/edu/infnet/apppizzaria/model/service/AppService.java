package br.edu.infnet.apppizzaria.model.service;

import org.springframework.stereotype.Service;

import br.edu.infnet.apppizzaria.model.domain.app.Projeto;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Service
public class AppService {
	
	private Projeto projeto;
	
	public void incluir(Projeto projeto) {
		this.projeto = projeto;
		
		AppImpressao.relatorio("Exibição do projeto " + projeto.getNome(), projeto);
	}
	
	public Projeto obterProjeto() {
		return projeto;
	}

}
