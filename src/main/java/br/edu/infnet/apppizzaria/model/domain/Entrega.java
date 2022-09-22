package br.edu.infnet.apppizzaria.model.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.apppizzaria.interfaces.IPrinter;
import br.edu.infnet.apppizzaria.model.exception.CarrinhoVazioException;
import br.edu.infnet.apppizzaria.model.exception.ClienteNuloException;

@Entity
@Table(name = "TB_ENTREGA")
public class Entrega implements IPrinter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String endereco;
	private Integer tempoPreparo;
	private LocalDateTime previsaoEntrega;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idMassa")
	private Set<Massa> massas;
	
	public Entrega() {
	}
	
	public Entrega(Cliente cliente, Set<Massa> produtos) throws ClienteNuloException, CarrinhoVazioException {
		if (cliente == null) {
			throw new ClienteNuloException("Impossível gerar uma entrega sem um Cliente");
		}
		
		if (produtos.size() < 1) {
			throw new CarrinhoVazioException("O carrinho não pode estár vazio");
		}
		
		this.previsaoEntrega = LocalDateTime.now();
		this.cliente = cliente;
		this.massas = produtos;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setMassas(Set<Massa> massas) {
		this.massas = massas;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Set<Massa> getMassas() {
		return massas;
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
		return "Entrega [endereco=" + endereco + ", tempoPreparo=" + tempoPreparo + ", previsaoEntrega=" + previsaoEntrega + "] " + cliente + " carrinho " + massas.size();
	}

}
