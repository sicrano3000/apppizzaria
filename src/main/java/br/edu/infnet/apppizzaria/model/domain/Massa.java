package br.edu.infnet.apppizzaria.model.domain;

import java.time.LocalDateTime;

import br.edu.infnet.apppizzaria.interfaces.IPrinter;
import br.edu.infnet.apppizzaria.model.exception.BordaNuloException;
import br.edu.infnet.apppizzaria.model.exception.ValorNegativoException;

public abstract class Massa implements IPrinter {
	
	private Integer id;
	protected String borda;
	private String tipo;
	private LocalDateTime data;
	
	public String tipoBorda() {
		if (getBorda() == null || borda == "") {
			setBorda("Brinde de queijo ralado");
		}
		
		return getBorda();
	}
	
	public abstract String calcularVenda() throws BordaNuloException, ValorNegativoException;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
