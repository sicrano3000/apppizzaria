package br.edu.infnet.apppizzaria.model.domain;

import java.util.Objects;

public class Pizza extends Massa {
	
	private String descricao;
	private Double valor;
	private String sabor;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	
	@Override
	public String tipoBorda() {
		if (getBorda() == "Catupiry") {
			setBorda("Borda de italianinho com catupiry");
		}
		
		return getBorda();
	}
	
	@Override
	public Double calcularVenda() {
		var valorBorda = borda != "tradicional" ? 1.2 : 1.5;
		return valor * valorBorda;
	}
	
	@Override
	public void impressao() {
		System.out.println("#pizza");
		System.out.println(this);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(descricao, sabor, valor);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(sabor, other.sabor) && Objects.equals(valor, other.valor);
	}
	
	@Override
	public String toString() {
		return "Pizza [descricao=" + descricao + ", valor=" + calcularVenda() + ", sabor=" + sabor + "] "  + super.toString();
	}

}
