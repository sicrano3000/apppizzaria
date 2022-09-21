package br.edu.infnet.apppizzaria.model.service;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppizzaria.model.domain.Esfirra;
import br.edu.infnet.apppizzaria.model.repository.EsfirraRepository;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Service
public class EsfirraService {
	
	@Autowired
	private EsfirraRepository esfirraRepository;
	
	public void incluir(Esfirra esfirra) {
		esfirra.setData(LocalDateTime.now());
		
		esfirraRepository.save(esfirra);
		
		AppImpressao.relatorio("Esfirra de " + esfirra.getSabor(), esfirra);
	}
	
	public Collection<Esfirra> obterLista() {
		return (Collection<Esfirra>) esfirraRepository.findAll();
	}
	
	public void excluir(Integer id) {
		esfirraRepository.deleteById(id);
	}

}
