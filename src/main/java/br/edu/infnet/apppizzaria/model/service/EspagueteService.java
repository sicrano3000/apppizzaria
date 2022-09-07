package br.edu.infnet.apppizzaria.model.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.apppizzaria.model.domain.Espaguete;
import br.edu.infnet.apppizzaria.test.AppImpressao;

@Service
public class EspagueteService {
	
	private static Map<Integer, Espaguete> mapaEspaguete = new HashMap<>();
	private static Integer id = 1;
	
	public void incluir(Espaguete espaguete) {
		espaguete.setId(id++);
		espaguete.setData(LocalDateTime.now());
		mapaEspaguete.put(espaguete.getId(), espaguete);
		
		AppImpressao.relatorio("Espaguete de " + espaguete.getSabor(), espaguete);
	}
	
	public Collection<Espaguete> obterLista() {
		return mapaEspaguete.values();
	}
	
	public void excluir(Integer id) {
		mapaEspaguete.remove(id);
	}

}
