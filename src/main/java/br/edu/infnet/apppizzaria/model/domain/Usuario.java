package br.edu.infnet.apppizzaria.model.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.infnet.apppizzaria.interfaces.IPrinter;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements IPrinter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	
	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Cliente> clientes;
	
	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Massa> massas;
	
	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Entrega> entregas;

	public List<Massa> getMassas() {
		return massas;
	}
	public void setMassas(List<Massa> massas) {
		this.massas = massas;
	}
	public List<Entrega> getEntregas() {
		return entregas;
	}
	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void impressao() {
		System.out.println("#usuario");
		System.out.println(this);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, nome, senha);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha);
	}
	
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}		

}
