package br.edu.infnet.apppizzaria.model.domain;

public class Esfirra extends Massa {
	
	private String descricao;
	private Double valor;
	private String sabor;
	
	@Override
	public String tipoBorda() {
		if (getBorda() == "Calabresa") {
			setBorda("Borda de calabresa com queijo");
		}
		
		return getBorda();
	}
	
	@Override
	public void impressao() {
		System.out.println("#esfirra");
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
		return "Esfirra [descricao=" + descricao + ", valor=" + valor + ", sabor=" + sabor + "] "  + super.toString();
	}

}
