package br.edu.infnet.apppizzaria.model.domain;

import java.time.LocalDateTime;

public class Entrega {
	
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
	public String toString() {
		return "Entrega [endereco=" + endereco + ", tempoPreparo=" + tempoPreparo + ", previsaoEntrega=" + previsaoEntrega + "]";
	}

}
