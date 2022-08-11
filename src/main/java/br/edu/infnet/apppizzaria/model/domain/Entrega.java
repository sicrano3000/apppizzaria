package br.edu.infnet.apppizzaria.model.domain;

import java.time.LocalDateTime;

import br.edu.infnet.apppizzaria.interfaces.IPrinter;

public class Entrega implements IPrinter {
	
	private String endereco;
	private Integer tempoPreparo;
	private LocalDateTime previsaoEntrega;
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getTempoPreparo() {
		return tempoPreparo;
	}
	public void setTempoPreparo(Integer tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}
	public LocalDateTime getPrevisaoEntrega() {
		return previsaoEntrega;
	}
	public void setPrevisaoEntrega(LocalDateTime previsaoEntrega) {
		this.previsaoEntrega = previsaoEntrega;
	}
	
	@Override
	public void impressao() {
		System.out.println("#entrega");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Entrega [endereco=" + endereco + ", tempoPreparo=" + tempoPreparo + ", previsaoEntrega=" + previsaoEntrega + "]";
	}

}
