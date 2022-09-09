package br.edu.infnet.apppizzaria.model.domain.app;

import java.util.List;

import br.edu.infnet.apppizzaria.interfaces.IPrinter;

public class Classe implements IPrinter {
	
	private String nome;
	private List<Atributo> atributos;

	public List<Atributo> getAtributos() {
		return atributos;
	}
	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void impressao() {
		System.out.println(" - - " + nome);
		
		atributos.forEach(atributo -> atributo.impressao());
	}

}
