package br.edu.infnet.apppizzaria.model.domain;

import java.time.LocalDateTime;

public abstract class Massa {
	
	private String borda;
	private String tipo;
	private LocalDateTime data;
	
	public String tipoBorda() {
		return (borda == null || borda == "") ? "Brinde de queijo ralado" : borda;
	}
	
	public abstract void impressao();
	
	public String getBorda() {
		return borda;
	}
	public void setBorda(String borda) {
		this.borda = borda;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Massa [borda=" + tipoBorda() + ", tipo=" + tipo + ", data=" + data + "]";
	}

}
