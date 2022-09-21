package br.edu.infnet.apppizzaria.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppizzaria.model.domain.Cliente;
import br.edu.infnet.apppizzaria.model.domain.Usuario;
import br.edu.infnet.apppizzaria.model.repository.ClienteRepository;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void incluir(Cliente cliente) {
		clienteRepository.save(cliente);
		
		AppImpressao.relatorio("Entrega para o cliente " + cliente.getNome(), cliente);
	}
	
	public Collection<Cliente> obterLista() {		
		return (Collection<Cliente>) clienteRepository.findAll();
	}
	
	public Collection<Cliente> obterLista(Usuario usuario) {
		return clienteRepository.obterLista(usuario.getId());
	}
	
	public void excluir(Integer id) {
		clienteRepository.deleteById(id);
	}

}
