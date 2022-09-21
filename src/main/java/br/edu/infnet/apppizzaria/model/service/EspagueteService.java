package br.edu.infnet.apppizzaria.model.service;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppizzaria.model.domain.Espaguete;
import br.edu.infnet.apppizzaria.model.repository.EspagueteRepository;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Service
public class EspagueteService {
	
	@Autowired
	private EspagueteRepository espagueteRepository;
	
	public void incluir(Espaguete espaguete) {
		espaguete.setData(LocalDateTime.now());
		
		espagueteRepository.save(espaguete);
		
		AppImpressao.relatorio("Espaguete de " + espaguete.getSabor(), espaguete);
	}
	
	public Collection<Espaguete> obterLista() {
		return (Collection<Espaguete>) espagueteRepository.findAll();
	}
	
	public void excluir(Integer id) {
		espagueteRepository.deleteById(id);
	}

}
