package br.edu.infnet.apppizzaria.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppizzaria.model.domain.Massa;
import br.edu.infnet.apppizzaria.model.domain.Usuario;
import br.edu.infnet.apppizzaria.model.repository.MassaRepository;

@Service
public class MassaService {
	
	@Autowired
	private MassaRepository massaRepository;
	
	public Collection<Massa> obterLista() {
		return (Collection<Massa>) massaRepository.findAll();
	}
	
	public Collection<Massa> obterLista(Usuario usuario) {
		return (Collection<Massa>) massaRepository.findAll(usuario.getId());
	}
	
	public void excluir(Integer id) {
		massaRepository.deleteById(id);
	}
	
}
