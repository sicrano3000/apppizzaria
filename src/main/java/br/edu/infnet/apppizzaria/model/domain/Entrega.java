package br.edu.infnet.apppizzaria.model.domain;

import java.time.LocalDateTime;
import java.util.Set;

import br.edu.infnet.apppizzaria.interfaces.IPrinter;

public class Entrega implements IPrinter {
	
	private Integer id;
	private String endereco;
	private Integer tempoPreparo;
	private LocalDateTime previsaoEntrega;
	private Cliente cliente;
	private Set<Object> carrinho;
	
	public Entrega(Cliente cliente) {
		this.previsaoEntrega = LocalDateTime.now();
		this.cliente = cliente;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<Object> getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Set<Object> carrinho) {
		this.carrinho = carrinho;
	}
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

	@Override
	public void impressao() {
		System.out.println("#entrega");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Entrega [endereco=" + endereco + ", tempoPreparo=" + tempoPreparo + ", previsaoEntrega=" + previsaoEntrega + "] " + cliente + " carrinho " + carrinho.size();
	}

}
