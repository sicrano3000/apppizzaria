package br.edu.infnet.apppizzaria.model.domain;

import java.time.LocalDateTime;
import java.util.Set;

import br.edu.infnet.apppizzaria.interfaces.IPrinter;
import br.edu.infnet.apppizzaria.model.exception.CarrinhoVazioException;
import br.edu.infnet.apppizzaria.model.exception.ClienteNuloException;

public class Entrega implements IPrinter {
	
	private Integer id;
	private String endereco;
	private Integer tempoPreparo;
	private LocalDateTime previsaoEntrega;
	private Cliente cliente;
	private Set<Object> carrinho;
	
	public Entrega(Cliente cliente, Set<Object> carrinho) throws ClienteNuloException, CarrinhoVazioException {
		if (cliente == null) {
			throw new ClienteNuloException("Impossível gerar uma entrega sem um Cliente");
		}
		
		if (carrinho.size() < 1) {
			throw new CarrinhoVazioException("O carrinho não pode estár vazio");
		}
		
		this.previsaoEntrega = LocalDateTime.now();
		this.cliente = cliente;
		this.carrinho = carrinho;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public Set<Object> getCarrinho() {
		return carrinho;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
