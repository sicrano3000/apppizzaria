package br.edu.infnet.apppizzaria.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppizzaria.model.domain.Entrega;
import br.edu.infnet.apppizzaria.model.domain.Usuario;
import br.edu.infnet.apppizzaria.model.repository.EntregaRepository;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Service
public class EntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	public void incluir(Entrega entrega) {
		entregaRepository.save(entrega);
		
		AppImpressao.relatorio("Entrega para " + entrega.getEndereco(), entrega);
	}
	
	public Collection<Entrega> obterLista() {
		return (Collection<Entrega>) entregaRepository.findAll();
	}
	
	public List<Entrega> obterLista(Usuario usuario) {
		return entregaRepository.findAll(usuario.getId());
	}
	
	public void excluir(Integer id) {
		entregaRepository.deleteById(id);;
	}

}
