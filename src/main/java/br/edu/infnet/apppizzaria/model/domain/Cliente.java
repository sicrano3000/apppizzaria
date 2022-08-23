package br.edu.infnet.apppizzaria.model.domain;

import br.edu.infnet.apppizzaria.interfaces.IPrinter;
import br.edu.infnet.apppizzaria.model.exception.CPFInvalidoException;

public class Cliente implements IPrinter {
	
	private Integer id;
	private String nome;
	private String cpf;
	private String email;
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Cliente() {
	}
	
	public Cliente(String nome, String email, String cpf) throws CPFInvalidoException {
		if (cpf == null) {
			throw new CPFInvalidoException("Não é possível aceitar CPF nulo");
		}
		
		if (cpf.isEmpty()) {
			throw new CPFInvalidoException("Não é possível aceitar CPF vazio");
		}
		
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

	@Override
	public void impressao() {
		System.out.println("#cliente");
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", email=" + email + "]";
	}	

}
