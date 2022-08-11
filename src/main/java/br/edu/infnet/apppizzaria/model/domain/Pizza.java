package br.edu.infnet.apppizzaria.model.domain;

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
	public String toString() {
		return "Pizza [descricao=" + descricao + ", valor=" + calcularVenda() + ", sabor=" + sabor + "] "  + super.toString();
	}

}
