package br.edu.infnet.apppizzaria.model.domain;

public class Pizza extends Massa {
	
	private String descricao;
	private Double valor;
	private String sabor;
	
	@Override
	public String tipoBorda() {
		if (getBorda() == "Catupiry") {
			setBorda("Borda de italianinho com catupiry");
		}
		
		return getBorda();
	}
	
	@Override
	public void impressao() {
		System.out.println("#pizza");
		System.out.println(this);
	}
	
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
	public String toString() {
		return "Pizza [descricao=" + descricao + ", valor=" + valor + ", sabor=" + sabor + "] "  + super.toString();
	}

}
