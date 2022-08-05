package br.edu.infnet.apppizzaria.model.domain;

import java.time.LocalDateTime;

public class Entrega {
	
	public String endereco;
	public Integer tempoPreparo;
	public LocalDateTime previsaoEntrega;
	
	@Override
	public String toString() {
		return "Entrega [endereco=" + endereco + ", tempoPreparo=" + tempoPreparo + ", previsaoEntrega=" + previsaoEntrega + "]";
	}

}
